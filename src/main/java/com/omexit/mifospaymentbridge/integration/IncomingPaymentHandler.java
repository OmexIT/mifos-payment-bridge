package com.omexit.mifospaymentbridge.integration;

import com.omexit.mifospaymentbridge.domain.payment.Payment;
import com.omexit.mifospaymentbridge.mifos.MifosService;
import com.omexit.mifospaymentbridge.services.payment.PaymentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

/**
 * Created by aomeri on 4/2/17.
 */
public class IncomingPaymentHandler {

    private final PaymentServiceImpl paymentService;
    private final MifosService mifosService;

    private Logger logger = LoggerFactory.getLogger(IncomingPaymentHandler.class);

    @Autowired
    public IncomingPaymentHandler(PaymentServiceImpl paymentService, MifosService mifosService) {
        this.paymentService = paymentService;
        this.mifosService = mifosService;
    }

    public void handlePayment(Message<Payment> message) {
        Payment payment = message.getPayload();

        paymentService.savePayment(payment);
    }


}
