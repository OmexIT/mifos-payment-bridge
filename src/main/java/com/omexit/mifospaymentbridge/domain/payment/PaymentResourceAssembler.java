package com.omexit.mifospaymentbridge.domain.payment;

import com.omexit.mifospaymentbridge.controller.payment.PaymentController;
import com.omexit.mifospaymentbridge.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by aomeri on 3/25/17.
 */
@Component
public class PaymentResourceAssembler implements ResourceAssembler<Payment, PaymentResource> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public PaymentResource toResource(Payment payment) {
        long paymentId = payment.getId();
        PaymentResource paymentResource = new PaymentResource(payment);
        try {
            paymentResource.add(linkTo(methodOn(PaymentController.class).getPaymentById(paymentId)).withSelfRel());
        } catch (ResourceNotFoundException e) {
            logger.error(e.getMessage(), e);
        }

        return paymentResource;
    }
}
