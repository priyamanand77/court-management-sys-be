package com.court.management.controller;

import com.court.management.dto.SignUpDto;
import com.court.management.response.SuccessResponse;
import com.court.management.service.SignUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sign-up")
@Slf4j
public class SignUpController {


    @Autowired
    private SignUpService signUpService;

    @PostMapping("/add-user")
    public ResponseEntity<SuccessResponse> addUserOrLAwyer(@RequestBody SignUpDto signUpDto) {
        log.info("inside controller , {}", signUpDto.toString());
        SuccessResponse successResponse = signUpService.addUsers(signUpDto);
        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @GetMapping("/get-all-req")
    public ResponseEntity<List<SignUpDto>> getAllReq() {
        log.info("Inside controlleer ");
        List<SignUpDto> allSignUpReq = signUpService.getAllSignUpReq();
        return ResponseEntity.status(HttpStatus.OK).body(allSignUpReq);

    }
}
