package com.omexit.mifospaymentbridge.services.payment;


import com.omexit.mifospaymentbridge.domain.channel.Channel;
import com.omexit.mifospaymentbridge.domain.payment.Payment;
import com.omexit.mifospaymentbridge.types.EntityType;
import com.omexit.mifospaymentbridge.types.PaymentStatus;

import java.util.Date;
import java.util.List;

/**
 * Created by Antony on 2/12/2016.
 */
public interface PaymentService {
    /**
     * Lists all payments
     * @return A list of payments
     */
    List<Payment> findAllPayments();

    /**
     * Saves a payment
     *
     * @param payment
     * @return Saved payent
     */
    Payment savePayment(Payment payment);

    /**
     * Saves bulk payments
     *
     * @param payments List of payments
     * @return List of saved payments
     */
    List<Payment> savePayments(Iterable<Payment> payments);

    /**
     * Method to find payment by ID
     * @param id
     * @return
     */
    Payment findPaymentById(Long id);

    /**
     * Method to query outgoing payments that are scheduled
     *
     * @param actualDisbursementDate
     * @param paymentStatus
     * @return
     */
    List<Payment> findTransactionsToProcess(Date actualDisbursementDate, PaymentStatus paymentStatus);

    /**
     * Method to find by externalId and channel
     *
     * @param externalId
     * @param channel
     * @return
     */
    Payment findByExternalIdAndChannel(String externalId, Channel channel);

    Payment findByTenantIdentifierAndEntityTypeAndMifosPaymentId(String tenantIdentifier, EntityType entityType, Long mifosPaymentId);
}
