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
@Table(name = "SIGN_UP_WORK")
public class SignUp {

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

    @Column(name = "role")
    private String role;

    @Column(name = "GOVERNMENT_ID_PROFF")
    private byte[] govtIdProff;

    @Column(name = "LAW_CERTFICATE")
    private byte[] lawCertficate;

    @Column(name = "DOB")
    private Timestamp dob;

    @Column(name = "Status")
    private String status;

    @Column(name = "ACTION_TIME")
    private Timestamp actionTime;

    @Column(name = "ACTION_TAKEN_BY")
    private String actionBy;

    @Column(name = "USERID")
    private String userId;

    @Column(name="PASSWORD")
    private String password;

}
