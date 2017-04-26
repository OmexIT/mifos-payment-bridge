package com.omexit.mifospaymentbridge.integration;

import com.omexit.mifospaymentbridge.domain.payment.IncomingPayment;
import com.omexit.mifospaymentbridge.domain.payment.Payment;
import com.omexit.mifospaymentbridge.mifos.MifosService;
import com.omexit.mifospaymentbridge.services.payment.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by aomeri on 4/2/17.
 */
public class IncomingPaymentHandler {

    private final PaymentService paymentService;
    private final MifosService mifosService;

    private Logger logger = LoggerFactory.getLogger(IncomingPaymentHandler.class);

    @Autowired
    public IncomingPaymentHandler(PaymentService paymentService, MifosService mifosService) {
        this.paymentService = paymentService;
        this.mifosService = mifosService;
    }

    /**
     * Endpoint handles incoming payments.
     *
     * @param message
     */
    @Transactional
    public void handlePayment(Message<IncomingPayment> message) {
        Payment payment = message.getPayload();
        //Check if transaction has been processed or processing
        Payment availablePayment = paymentService.findByExternalIdAndChannel(payment.getExternalId(), payment.getChannel());
        if (availablePayment != null) {
            if(!availablePayment.getPaymentStatus().isPaymentProcessing() ||
                    !availablePayment.getPaymentStatus().isPaymentComplete()){
                payment.setId(availablePayment.getId());
            }else {
                logger.warn("[TenantIdentifier: {}, EntityType: {}, MifosPaymentId: {}] Payment failed Reason: {}", payment.getTenantIdentifier(), payment.getEntityType(), payment.getMifosPaymentId(), availablePayment.getPaymentStatus().getCode());
            }
        }

        paymentService.savePayment(payment);
    }


}
