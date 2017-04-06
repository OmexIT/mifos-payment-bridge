package com.omexit.mifospaymentbridge.controller.payment;

import com.omexit.mifospaymentbridge.domain.payment.Payment;
import com.omexit.mifospaymentbridge.domain.payment.PaymentResourceAssembler;
import com.omexit.mifospaymentbridge.exception.ResourceNotFoundException;
import com.omexit.mifospaymentbridge.services.payment.PaymentService;
import com.omexit.mifospaymentbridge.types.ReasonCode;
import com.omexit.mifospaymentbridge.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.omexit.mifospaymentbridge.util.BaseController.API_PATH;

/**
 * The PaymentController class is a RESTful web service controller. The
 * <code>@RestController</code> annotation informs Spring that each
 * <code>@RequestMapping</code> method returns a <code>@ResponseBody</code>.
 *
 * @author Antony Omeri
 */
@RestController
@RequestMapping(value = API_PATH)
public class PaymentController extends BaseController {

    private final PaymentService paymentService;
    private final PaymentResourceAssembler paymentResourceAssembler;

    @Autowired
    public PaymentController(PaymentService paymentService, PaymentResourceAssembler paymentResourceAssembler) {
        this.paymentService = paymentService;
        this.paymentResourceAssembler = paymentResourceAssembler;
    }

    /**
     * Web service endpoint to fetch all Payment entities. The service returns the collection of Payment entity in JSON
     *
     * @return A ResponseEntity containing a Collection of Payment Objects
     */
    @RequestMapping(
            value = PAYMENT_URL,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Payment>> getPayments() {
        List<Payment> payments = paymentService.findAllPayments();

        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    /**
     * Web service endpoint to fetch a single Payment entity by primary key identifier
     * <p>
     * If found the Payment is returned as JSON with HTTP status 200
     * <p>
     * If not found, the service returns an empty response body with HTTP status 404
     *
     * @param id
     * @return A ResponseEntity containing a single Payment object,
     */
    @RequestMapping(
            value = GET_PAYMENT_URL,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resource<Payment>> getPaymentById(@PathVariable("paymentId") Long id) throws ResourceNotFoundException {
        Payment payment = paymentService.findPaymentById(id);
        if (payment == null) {
            throw new ResourceNotFoundException(String.format("Payment with Id: %s not found", id),
                    "Resource not found!",
                    ReasonCode.RESOURCE_NOT_FOUND);
        }

        return new ResponseEntity<>(paymentResourceAssembler.toResource(payment), HttpStatus.OK);
    }

    /**
     * Web service endpoint to create a single Payment entity. The HTTP request
     * body is expected to contain a Payment object in JSON format. The
     * Payment is persisted in the data repository.
     * <p>
     * If created successfully, the persisted Payment is returned as JSON with
     * HTTP status 201.
     * <p>
     * If not created successfully, the service returns an empty response body
     * with HTTP status 500.
     *
     * @param payment The Payment object to be created.
     * @return A ResponseEntity containing a single Payment object, if created
     * successfully, and a HTTP status code as described in the method
     * comment.
     */
    @RequestMapping(
            value = PAYMENT_URL,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resource<Payment>> createPayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentService.savePayment(payment);

        return new ResponseEntity<>(paymentResourceAssembler.toResource(savedPayment), HttpStatus.CREATED);
    }

}
