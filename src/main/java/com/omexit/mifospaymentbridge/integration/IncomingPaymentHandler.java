package com.omexit.mifospaymentbridge.integration;

import com.omexit.mifospaymentbridge.domain.payment.Payment;
import com.omexit.mifospaymentbridge.services.payment.PaymentServiceImpl;
import com.omexit.mifospaymentbridge.types.PaymentStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

/**
 * Created by aomeri on 4/2/17.
 */
public class IncomingPaymentHandler {

    private final PaymentServiceImpl paymentService;

    private Logger logger = LoggerFactory.getLogger(IncomingPaymentHandler.class);

    @Autowired
    public IncomingPaymentHandler(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    public void handlePayment(Message<Payment> message) {
        Payment incomingPayment = message.getPayload();
        //Find if payment exists
        Payment payment =paymentService.findByExternalIdAndChannel(incomingPayment.getExternalId(),incomingPayment.getChannel());
        if(payment!=null){
            //if not null, check
            if(payment.getPaymentStatus()!= PaymentStatus.PAYMENT_PROCESSING
                    ||payment.getPaymentStatus()!= PaymentStatus.PAYMENT_COMPLETE){

            }
        }

        paymentService.savePayment(payment);
    }

    private void performSavingsAccountTransaction(){

    }

    private void performLoanRepaymentTransaction(){

    }
}
