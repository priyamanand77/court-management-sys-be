package com.court.management.service;

import com.court.management.dto.SignUpDto;
import com.court.management.request.AcceptOrRegect;
import com.court.management.response.SuccessResponse;

import java.util.List;

public interface SignUpService {

    SuccessResponse addUsers(SignUpDto signUpDto);

    List<SignUpDto> getAllSignUpReq();
}
