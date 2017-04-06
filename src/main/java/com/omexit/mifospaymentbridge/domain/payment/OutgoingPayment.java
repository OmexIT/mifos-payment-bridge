package com.omexit.mifospaymentbridge.domain.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omexit.mifospaymentbridge.types.PaymentType;
import com.omexit.mifospaymentbridge.util.DateUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Antony on 2/9/2016.
 */
@Data
@Entity(name = "outgoing")
@EqualsAndHashCode(callSuper = false)
public class OutgoingPayment extends Payment {

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = DateUtil.DEFAULT_DATE_FORMAT)
    @JsonProperty("disbursement_date")
    @Column(name = "disbursement_date", nullable = false)
    private Date actualDisbursementDate;

    public PaymentType getPaymentType(){
        return PaymentType.OUTGOING;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + super.getId() +
                ", clientId=" + super.getClientId() +
                ", action='" + super.getAction() + '\'' +
                ", entityId=" + super.getEntityId() +
                ", entityType=" + super.getEntityType() +
                ", actionType=" + super.getActionType() +
                ", paymentAccount='" + super.getPaymentAccount() + '\'' +
                ", transactionAmount=" + super.getTransactionAmount() +
                ", channel=" + super.getChannel() +
                ", channelEndpointTag='" + super.getChannelEndpointTag()+ '\'' +
                ", paymentStatus=" + super.getPaymentStatus() +
                ", paymentType=" + super.getPaymentType() +
                ", errorCode=" + super.getReasonCode() +
                ", statusReasonCodeMessage='" + super.getStatusReasonCodeMessage() + '\'' +
                ", currency='" + super.getCurrency() + '\'' +
                ", externalId='" + super.getExternalId() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", retryCount=" + super.getRetryCount() +
                ", dateCreated=" + super.getDateCreated() +
                ", lastModified=" + super.getLastModified() +
                ", actualDisbursementDate=" + this.getActualDisbursementDate() +
                '}';
    }
}
