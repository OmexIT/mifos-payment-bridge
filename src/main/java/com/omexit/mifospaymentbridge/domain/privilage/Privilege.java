package com.omexit.mifospaymentbridge.domain.privilage;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by aomeri on 9/3/16.
 */
@Data
@Entity(name = "tbl_privileges")
public class Privilege  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "privilege_name")
    private String name;
    @Column(name = "privilege_description")
    private String description;

    public Privilege(){

    }
}