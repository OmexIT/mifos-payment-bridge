package com.omexit.mifospaymentbridge.services.payment;

import com.omexit.mifospaymentbridge.domain.payment.Payment;
import org.springframework.messaging.Message;

import java.util.concurrent.Future;

/**
 * Created by aomeri on 11/17/16.
 */
public interface OutgoingPaymentGateway {

    public Future<Message<Payment>> print(Message<Payment> message);
}
