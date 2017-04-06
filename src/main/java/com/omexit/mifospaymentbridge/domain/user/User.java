package com.omexit.mifospaymentbridge.domain.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omexit.mifospaymentbridge.domain.role.Role;
import com.omexit.mifospaymentbridge.types.IdType;
import com.omexit.mifospaymentbridge.util.DateUtil;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by aomeri on 6/22/2015.
 */
@Data
@Entity
@SequenceGenerator(initialValue = 1, name = "userIdGen", sequenceName = "user_sequence", allocationSize = 1)
@Table(name = "tbl_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "userIdGen")
    private Long id;
    @JsonProperty("first_name")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @JsonProperty("middle_name")
    @Column(name = "middle_name")
    private String middleName;
    @JsonProperty("last_name")
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @JsonProperty("user_name")
    @Column(unique = true, name = "user_name", nullable = false)
    private String username;
    @JsonProperty("phone_number")
    @Column(name = "phone_number")
    private String phoneNumber;
    @JsonProperty("email")
    @Column(name = "email")
    private String email;
    @JsonProperty("id_type")
    @Column(name = "id_type")
    private IdType idType;
    @JsonProperty("id_number")
    @Column(name = "id_number")
    private String idNumber;
    @JsonProperty("designation")
    @Column(name = "designation")
    private String designation;
    @JsonIgnore
    @Column(name = "user_password")
    private String password;
    @Column(name = "is_enabled")
    private boolean enabled;
    @JsonProperty("is_credentials_expired")
    @Column(name = "is_acredentials_expired", nullable = false)
    private boolean credentialsExpired;
    @JsonProperty("is_account_expired")
    @Column(name = "is_acaccount_expired", nullable = false)
    private boolean accountExpired;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tbl_user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;
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

    public User() {
    }

    public User(User user) {
        this.id = user.id;
        this.firstName = user.firstName;
        this.middleName = user.middleName;
        this.lastName = user.lastName;
        this.username = user.username;
        this.email = user.email;
        this.idNumber = user.idNumber;
        this.designation = user.designation;
        this.phoneNumber = user.phoneNumber;
        this.password = user.password;
        this.enabled = user.enabled;
        this.credentialsExpired = user.credentialsExpired;
        this.accountExpired = user.accountExpired;
        this.roles = user.roles;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
                ", designation='" + designation + '\'' +
                ", enabled=" + enabled +
                ", credentialsExpired=" + credentialsExpired +
                ", accountExpired=" + accountExpired +
                ", roles=" + roles +
                ", dateCreated=" + dateCreated +
                ", lastModified=" + lastModified +
                '}';
    }
}
