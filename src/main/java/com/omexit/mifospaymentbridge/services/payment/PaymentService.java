package com.omexit.mifospaymentbridge.services.payment;


import com.omexit.mifospaymentbridge.domain.channel.Channel;
import com.omexit.mifospaymentbridge.domain.payment.Payment;
import com.omexit.mifospaymentbridge.types.PaymentStatus;

import java.util.Date;
import java.util.List;

/**
 * Created by Antony on 2/12/2016.
 */
public interface PaymentService {
    List<Payment> findAllPayments();

    Payment savePayment(Payment payment);

    List<Payment> savePayments(Iterable<Payment> payments);

    Payment findPaymentById(Long id);

    List<Payment> findTransactionsToProcess(Date actualDisbursementDate, PaymentStatus paymentStatus);

    Payment findByExternalIdAndChannel(String externalId, Channel channel);
}
