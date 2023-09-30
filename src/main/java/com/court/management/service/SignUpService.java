package com.court.management.service;

import com.court.management.dto.SignUpDto;
import com.court.management.request.AcceptOrRegect;
import com.court.management.response.SuccessResponse;

import java.util.List;

public interface SignUpService {

    SuccessResponse addUsers(SignUpDto signUpDto);

    SuccessResponse acceptOrRequestUser(AcceptOrRegect acceptOrRegect);

    List<SignUpDto> getAllUserByStatus(String status);

    List<SignUpDto> getAllSignUpReq();
}
