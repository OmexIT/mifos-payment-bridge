package com.omexit.mifospaymentbridge.integration;

import com.omexit.mifospaymentbridge.domain.channel.Channel;
import com.omexit.mifospaymentbridge.domain.payment.OutgoingPayment;
import com.omexit.mifospaymentbridge.mifos.MifosService;
import com.omexit.mifospaymentbridge.mifos.domain.client.Client;
import com.omexit.mifospaymentbridge.services.payment.PaymentServiceImpl;
import com.omexit.mifospaymentbridge.types.PaymentStatus;
import com.omexit.mifospaymentbridge.types.ReasonCode;
import com.omexit.mifospaymentbridge.util.MSISDNUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Created by aomeri on 4/2/17.
 */
public class OutgoingPaymentHandler {

    private final PaymentServiceImpl paymentService;
    private final MifosService mifosService;
    private Logger logger = LoggerFactory.getLogger(OutgoingPaymentHandler.class);

    @Autowired
    public OutgoingPaymentHandler(PaymentServiceImpl paymentService, MifosService mifosService) {
        this.paymentService = paymentService;
        this.mifosService = mifosService;
    }

    /**
     * Method to handle outgoing payments from mifos
     *
     * @param message OutgoingPayment object wrapped in message envelope
     */
    @Transactional
    public void handlePayment(Message<OutgoingPayment> message) {
        try {
            OutgoingPayment payment = message.getPayload();
            logger.info("- handlePayment({})", payment);
            Channel channel = payment.getChannel();
            Long clientId = payment.getClientId();
            String tenantIdentifier = payment.getTenantIdentifier();
            boolean isPretty = false;
            String fields = "mobileNo";

            if (channel != null) {
                switch (channel.getChannelType()) {
                    case MOBILE_MONEY_CHANNEL:
                        logger.info("Fetching client: {} details in tenant: {} ...", clientId, tenantIdentifier);
                        Client client = mifosService.getClientByID(clientId, tenantIdentifier, isPretty, fields);
                        if (client != null) {
                            String mobileNo = client.getMobileNo();
                            if (!MSISDNUtil.isValidNumber(mobileNo, channel.getPhoneNumberDefaultRegion())) {
                                payment.setPaymentStatus(PaymentStatus.PAYMENT_FAILED);
                                payment.setReasonCode(ReasonCode.INVALID_PHONE_NUMBER);
                                logger.warn("Unable to fetch a valid phone number for mifos tenant: {} client id: {} ", payment.getTenantIdentifier(), payment.getClientId());
                            } else {
                                payment.setPaymentStatus(PaymentStatus.PAYMENT_PENDING);
                                payment.setReasonCode(ReasonCode.OK);
                            }
                            payment.setPaymentAccount(mobileNo);
                        }
                        break;
                    case BANKING_CHANNEL:
                        //TODO:Get client bank details
                        break;
                    case EMAIL_MONEY_CHANNEL:
                        //TODO:Get client email details
                        break;
                    default:
                        logger.warn("Invalid channel type");
                        break;
                }
            }
            payment = (OutgoingPayment) paymentService.savePayment(payment);
            logger.debug("Saved, payment: {}", payment);
        } catch (IOException e) {
            logger.info(e.getMessage(), e);
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
    }
}
