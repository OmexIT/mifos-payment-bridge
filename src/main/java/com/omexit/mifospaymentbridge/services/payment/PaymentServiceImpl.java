package com.omexit.mifospaymentbridge.services.payment;

import com.omexit.mifospaymentbridge.domain.channel.Channel;
import com.omexit.mifospaymentbridge.domain.payment.Payment;
import com.omexit.mifospaymentbridge.repository.PaymentRepository;
import com.omexit.mifospaymentbridge.types.PaymentStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Antony on 2/12/2016.
 */
@Service
public class PaymentServiceImpl  implements PaymentService {

    private final PaymentRepository paymentRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> savePayments(Iterable<Payment> payments) {
        return paymentRepository.save(payments);
    }

    @Override
    public Payment findPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public List<Payment> findTransactionsToProcess(Date actualDisbursementDate, PaymentStatus paymentStatus) {
        return paymentRepository.findTransactionsToProcess(actualDisbursementDate, paymentStatus);
    }

    @Override
    public Payment findByExternalIdAndChannel(String externalId, Channel channel) {
        return paymentRepository.findByExternalIdAndChannel(externalId,channel);
    }
}
