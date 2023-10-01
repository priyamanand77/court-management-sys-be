package com.court.management.serviceImpl;

import com.court.management.constants.CourtConstants;
import com.court.management.exception.CourtException;
import com.court.management.model.SignUp;
import com.court.management.model.UserTable;
import com.court.management.repo.SignUpRepoWork;
import com.court.management.repo.UserRepo;
import com.court.management.request.ApproveRejectReq;
import com.court.management.response.SuccessResponse;
import com.court.management.service.ApproveRejectService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@Slf4j
public class ApproveRejectServiceImpl implements ApproveRejectService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SignUpRepoWork signUpRepoWork;

    @Autowired
    private UserRepo userRepo;

    private UserTable fromSignupToUser(SignUp sign) {
        return modelMapper.map(sign, UserTable.class);
    }

    @Override
    public SuccessResponse approveReject(ApproveRejectReq approveRejectReq) {

        log.info("Inside ApproveRejectServiceImpl : {}",approveRejectReq );
        try {
            SignUp signup = signUpRepoWork.findById(approveRejectReq.getId()).orElseThrow(() -> new CourtException("Unable to featch"));
            signup.setStatus( approveRejectReq.getAction().equalsIgnoreCase("approve")? approveRejectReq.getAction().toUpperCase()+"D":approveRejectReq.getAction().toUpperCase()+"ED");
            signup.setActionTime(new Timestamp(new Date().getTime()));

            signUpRepoWork.save(signup);
            if (approveRejectReq.getAction().equalsIgnoreCase("approve")) {
                UserTable userTable = fromSignupToUser(signup);
                userTable.setId(0);
                userRepo.save(userTable);
                return SuccessResponse.builder().status(HttpStatus.OK.value()).message(CourtConstants.SUCCESS).data("Approved").build();

            }else
            {
                return SuccessResponse.builder().status(HttpStatus.OK.value()).message(CourtConstants.SUCCESS).data("Rejected").build();

            }
        } catch (Exception e) {
            log.error(e.toString());
            throw new CourtException("Unable to add into db , msg : " + e.getMessage());
        }
    }
}
