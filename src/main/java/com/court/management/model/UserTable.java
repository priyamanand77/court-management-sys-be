package com.court.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_TABLE")
public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "PINCODE")
    private String pincode;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "FULL_ADDRESS")
    private String address;

    @Column(name = "EMAIL_ID")
    private String email;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "GOVERNMENT_ID_PROFF" , length = 200000)
    @Lob
    private byte[] govtIdProff;

    @Column(name = "LAW_CERTFICATE")
    @Lob
    private byte[] lawCertficate;

    @Column(name = "DOB")
    private Timestamp dob;

    @Column(name = "USERID")
    private String userId;

    @Column(name="PASSWORD")
    private String password;


}
