package com.omexit.mifospaymentbridge.domain.payment;

import com.fasterxml.jackson.annotation.*;
import com.omexit.mifospaymentbridge.domain.channel.Channel;
import com.omexit.mifospaymentbridge.types.*;
import com.omexit.mifospaymentbridge.util.DateUtil;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Antony on 2/9/2016.
 */
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "payment_type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = IncomingPayment.class, name = "incoming"),
        @JsonSubTypes.Type(value = OutgoingPayment.class, name = "outgoing")})
@Entity(name = "tbl_payments")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("client_id")
    @Column(name = "client_id")
    private Long clientId;
    @JsonProperty("action")
    @Column(name = "action", length = 50)
    private String action;
    @JsonProperty("entity_id")
    @Column(name = "entity_id")
    private Long entityId;
    @JsonProperty("entity_type")
    @Column(name = "entity_type")
    private EntityType entityType;
    @JsonProperty("mifos_payment_id")
    @Column(name = "mifos_payment_id")
    private Long mifosPaymentId;
    @JsonProperty("action_type")
    @Column(name = "action_type")
    private ActionType actionType;
    @JsonProperty("payment_account")
    @Column(name = "payment_account", length = 100)
    private String paymentAccount;
    @JsonProperty("transaction_amount")
    @Column(name = "transaction_amount")
    private Double transactionAmount;
    @JsonProperty("tenant_identifier")
    @Column(name = "tenant_identifier", length = 100)
    private String tenantIdentifier;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "channel_id")
    private Channel channel;
    @Transient
    @JsonProperty("channel_endpoint_tag")
    private String channelEndpointTag;
    @JsonProperty("payment_status")
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;
    @Transient
    @JsonProperty("payment_type")
    private PaymentType paymentType;
    @JsonProperty("reason_code")
    @Column(name = "reason_code")
    private ReasonCode reasonCode;
    @JsonProperty("status_reason_code_message")
    @Transient
    private String statusReasonCodeMessage;
    @JsonProperty("currency")
    @Column(name = "currency")
    private String currency;
    @JsonProperty("external_id")
    @Column(name = "external_id", length = 50)
    private String externalId;
    @JsonProperty("description")
    @Column(name = "description")
    private String description;
    @JsonProperty("retry_count")
    @Column(name = "retry_count", nullable = false)
    private Integer retryCount = 0;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = DateUtil.DEFAULT_DATE_FORMAT)
    @JsonProperty("date_created")
    @Column(name = "date_created", updatable = false, nullable = false)
    private Date dateCreated;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = DateUtil.DEFAULT_DATE_FORMAT)
    @JsonProperty("last_modified")
    @Column(name = "last_modified", nullable = false)
    private Date lastModified;

    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        this.dateCreated = date;
        this.lastModified = date;
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastModified = new Date();
    }

    public String getStatusReasonCodeMessage() {
        this.statusReasonCodeMessage = "";
        ReasonCode reasonCode = getReasonCode();
        if (reasonCode != null) {
            this.statusReasonCodeMessage = reasonCode.getName();
        }
        return this.statusReasonCodeMessage;
    }

    public String getChannelEndpointTag() {
        this.channelEndpointTag = "";
        Channel channel = getChannel();
        if (channel != null) {
            this.channelEndpointTag =channel.getChannelEndpointTag();
        }
        return this.channelEndpointTag;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", action='" + action + '\'' +
                ", entityId=" + entityId +
                ", entityType=" + entityType +
                ", actionType=" + actionType +
                ", paymentAccount='" + paymentAccount + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", channel=" + channel +
                ", channelEndpointTag='" + channelEndpointTag + '\'' +
                ", paymentStatus=" + paymentStatus +
                ", paymentType=" + paymentType +
                ", reasonCode=" + reasonCode +
                ", statusReasonCodeMessage='" + statusReasonCodeMessage + '\'' +
                ", currency='" + currency + '\'' +
                ", externalId='" + externalId + '\'' +
                ", description='" + description + '\'' +
                ", retryCount=" + retryCount +
                ", dateCreated=" + dateCreated +
                ", lastModified=" + lastModified +
                '}';
    }
}
