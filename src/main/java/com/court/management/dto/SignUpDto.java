package com.court.management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto {


    private long id;

    private String pincode;

    private String firstName;

    private String lastName;

    private String gender;

    private String address;

    private String email;

    private String role;

    private byte[] govtIdProff;

    private byte[] lawCertficate;

    private Timestamp dob;

    private String status;

    private Timestamp actionTime;

    private String actionBy;

    private String userId;

    private String password;

}
