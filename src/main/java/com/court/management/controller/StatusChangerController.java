package com.court.management.controller;

import com.court.management.request.ApproveRejectReq;
import com.court.management.response.SuccessResponse;
import com.court.management.service.ApproveRejectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
@Slf4j
public class StatusChangerController {

    @Autowired
    private ApproveRejectService approveRejectService;

    @PostMapping("/action/{id}/{stat}")
    ResponseEntity<SuccessResponse> approveReject(@PathVariable(name = "id") long id , @PathVariable(name = "stat") String stat)
    {
        ApproveRejectReq approveRejectReq = ApproveRejectReq.builder().id(id).action(stat).build();
        log.info("Inside controller , {}",approveRejectReq);
        SuccessResponse successResponse = approveRejectService.approveReject(approveRejectReq);
        return  ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }



}
