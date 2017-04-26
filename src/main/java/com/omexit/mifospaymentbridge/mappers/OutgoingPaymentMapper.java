package com.omexit.mifospaymentbridge.mappers;

import com.omexit.mifospaymentbridge.domain.channel.Channel;
import com.omexit.mifospaymentbridge.services.channel.ChannelService;
import com.omexit.mifospaymentbridge.domain.payment.OutgoingPayment;
import com.omexit.mifospaymentbridge.domain.payment.Payment;
import com.omexit.mifospaymentbridge.types.ActionType;
import com.omexit.mifospaymentbridge.types.EntityType;
import com.omexit.mifospaymentbridge.types.PaymentStatus;
import com.omexit.mifospaymentbridge.types.ReasonCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by aomeri on 4/2/17.
 *
 * Provides JDBC row mapper for outgoing payments from mifos.
 */
@Component
public class OutgoingPaymentMapper implements RowMapper<Payment> {
    private final ChannelService channelService;

    @Autowired
    public OutgoingPaymentMapper(ChannelService channelService) {
        this.channelService = channelService;
    }

    /**
     * Method to map query resultset to outgoing message
     *
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public OutgoingPayment mapRow(ResultSet resultSet, int i) throws SQLException {
        Long entityId = resultSet.getLong("entity_id");
        Long mifosPaymentId = resultSet.getLong("mifos_payment_id");
        Long clientId = resultSet.getLong("client_id");
        Date transactionDate = resultSet.getDate("transaction_date");
        Double amount = resultSet.getDouble("amount");
        String channelName = resultSet.getString("channel");
        String currencyCode = resultSet.getString("currency_code");
        String tenantIdentifier = resultSet.getString("tenant_identifier");
        int entityType = resultSet.getInt("entity_type");
        int actionType = resultSet.getInt("action_type");

        OutgoingPayment outgoingPayment = new OutgoingPayment();
        outgoingPayment.setTransactionAmount(amount);
        outgoingPayment.setActualDisbursementDate(transactionDate);
        outgoingPayment.setEntityId(entityId);
        outgoingPayment.setMifosPaymentId(mifosPaymentId);
        outgoingPayment.setEntityType(EntityType.fromInt(entityType));
        outgoingPayment.setActionType(ActionType.fromInt(actionType));
        outgoingPayment.setClientId(clientId);
        outgoingPayment.setCurrency(currencyCode);
        outgoingPayment.setTenantIdentifier(tenantIdentifier);
        Channel channel = channelService.findChannelByChannelName(channelName);
        if (channel != null) {
            outgoingPayment.setChannel(channel);
            outgoingPayment.setPaymentStatus(PaymentStatus.PAYMENT_PENDING);
            outgoingPayment.setReasonCode(ReasonCode.OK);
        } else {
            outgoingPayment.setPaymentStatus(PaymentStatus.PAYMENT_FAILED);
            outgoingPayment.setReasonCode(ReasonCode.CHANNEL_NOT_FOUND);
        }
        return outgoingPayment;
    }
}
