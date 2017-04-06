package com.omexit.mifospaymentbridge.controller.channel;

import com.omexit.mifospaymentbridge.domain.channel.Channel;
import com.omexit.mifospaymentbridge.domain.payment.Payment;
import com.omexit.mifospaymentbridge.domain.payment.PaymentResourceAssembler;
import com.omexit.mifospaymentbridge.exception.ResourceNotFoundException;
import com.omexit.mifospaymentbridge.services.channel.ChannelService;
import com.omexit.mifospaymentbridge.services.payment.PaymentService;
import com.omexit.mifospaymentbridge.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.omexit.mifospaymentbridge.util.BaseController.API_PATH;

/**
 * The ChannelControllerV1 class is a RESTful web service controller. The
 * <code>@RestController</code> annotation informs Spring that each
 * <code>@RequestMapping</code> method returns a <code>@ResponseBody</code>.
 *
 * @author Antony Omeri
 */
@RestController
@RequestMapping(value = API_PATH)
public class ChannelController extends BaseController {
    private final PaymentService paymentService;
    private final ChannelService channelService;
    private final PaymentResourceAssembler paymentResourceAssembler;

    @Autowired
    public ChannelController(ChannelService channelService, PaymentResourceAssembler paymentResourceAssembler, PaymentService paymentService) {
        this.channelService = channelService;
        this.paymentResourceAssembler = paymentResourceAssembler;
        this.paymentService = paymentService;
    }

    /**
     * Web service end point to fetch all Channel entities. The service returns the collection of Channel entity in JSON
     *
     * @return A ResponseEntity containing a Collection of Channel Objects
     */
    @RequestMapping(
            value = CHANNEL_URL,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Channel>> getChannels() {
        List<Channel> channels = channelService.findAllChannels();

        return new ResponseEntity<>(channels, HttpStatus.OK);
    }


    /**
     * Web service endpoint to fetch a single Channel entity by primary key identifier
     * <p>
     * If found the Channel is returned as JSON with HTTP status 200
     * <p>
     * If not found, the service returns an empty response body with HTTP status 404
     *
     * @param channelId
     * @return A ResponseEntity containing a single Channel object,
     */
    @RequestMapping(
            value = GET_CHANNEL_URL,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Channel> getChannelById(@PathVariable("channelId") Long channelId) throws ResourceNotFoundException {
        Channel channel = channelService.findchannelbyId(channelId);
        if (channel == null) {
            return new ResponseEntity<Channel>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Channel>(channel, HttpStatus.OK);
    }

    /**
     * Web service endpoint to create a single Channel entity. The HTTP request
     * body is expected to contain a Channel object in JSON format. The
     * Channel is persisted in the data repository.
     * <p>
     * If created successfully, the persisted Channel is returned as JSON with
     * HTTP status 201.
     * <p>
     * If not created successfully, the service returns an empty response body
     * with HTTP status 500.
     *
     * @param channel The Channel object to be created.
     * @return A ResponseEntity containing a single Channel object, if created
     * successfully, and a HTTP status code as described in the method
     * comment.
     * @throws Exception Thrown if a problem occurs completing the request.
     */
    @RequestMapping(
            value = CHANNEL_URL,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel) throws ResourceNotFoundException {
        Channel savedChannel = channelService.saveOrUpdateChannel(channel);

        return new ResponseEntity<Channel>(savedChannel, HttpStatus.CREATED);
    }

    /**
     * Web service endpoint to update a single Channel entity. The HTTP request
     * body is expected to contain a Channel object in JSON format. The
     * Channel is updated in the data repository.
     * <p>
     * If updated successfully, the persisted Channel is returned as JSON with
     * HTTP status 200.
     * <p>
     * If not found, the service returns an empty response body and HTTP status
     * 404.
     * <p>
     * If not updated successfully, the service returns an empty response body
     * with HTTP status 500.
     *
     * @param channel The Channel object to be updated.
     * @return A ResponseEntity containing a single Channel object, if updated
     * successfully, and a HTTP status code as described in the method
     * comment.
     * @throws Exception Thrown if a problem occurs completing the request.
     */
    @RequestMapping(
            value = GET_CHANNEL_URL,
            method = RequestMethod.PATCH,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Channel> updateChannel(@RequestBody Channel channel) {
        Channel updatedChannel = channelService.saveOrUpdateChannel(channel);

        return new ResponseEntity<Channel>(updatedChannel, HttpStatus.OK);
    }

    @RequestMapping(
            value = GET_CHANNEL_PAYMENT_URL,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Payment>> getChannelPayments(@PathVariable("channelId") Long channelId) {
        List<Payment> payments = paymentService.findAllPayments();

        return new ResponseEntity<>(payments, HttpStatus.OK);
    }
}
