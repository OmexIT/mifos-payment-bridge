package com.omexit.mifospaymentbridge.domain.channel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omexit.mifospaymentbridge.types.ChannelType;
import com.omexit.mifospaymentbridge.util.DateUtil;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Antony on 2/10/2016.
 */
@Data
@Entity(name = "tbl_channels")
public class Channel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("channel_name")
    @Column(name = "channel_name", length = 150)
    private String channelName;
    @JsonProperty("channel_endpoint_tag")
    @Column(name = "channel_endpoint_tag", length = 100, nullable = false, unique = true)
    private String channelEndpointTag;
    @JsonProperty("channel_type")
    @Column(name = "channel_type", nullable = false)
    private ChannelType channelType;
    @JsonProperty("is_active")
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @JsonProperty("is_callback")
    @Column(name = "is_callback", nullable = false)
    private boolean isCallback;
    @JsonProperty("phone_number_default_region")
    @Column(name = "phone_number_default_region", length = 5)
    private String phoneNumberDefaultRegion;
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
}
