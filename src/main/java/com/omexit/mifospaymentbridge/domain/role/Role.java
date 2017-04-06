package com.omexit.mifospaymentbridge.domain.role;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omexit.mifospaymentbridge.domain.privilage.Privilege;
import com.omexit.mifospaymentbridge.util.DateUtil;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by aomeri on 6/22/2015.
 */
@Data
@Entity
@SequenceGenerator(initialValue = 1, name = "roleIdGen", sequenceName = "role_sequence", allocationSize = 1)
@Table(name = "tbl_role")
public class Role implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "roleIdGen")
    private Long id;
    @Column(name = "role_name")
    private String name;
    @Column(name = "role_description")
    private String description;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tbl_role_privileges",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private List<Privilege> privileges;
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

    public Role(){
        privileges=new ArrayList<>();
    }

    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        dateCreated = date;
        lastModified = date;
    }

    @PreUpdate
    protected void onUpdate() {
        lastModified = new Date();
    }

}
