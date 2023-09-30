package com.court.management.serviceImpl;

import com.court.management.constants.CourtConstants;
import com.court.management.dto.SignUpDto;
import com.court.management.exception.CourtException;
import com.court.management.model.SignUp;
import com.court.management.repo.SignUpRepoWork;
import com.court.management.request.AcceptOrRegect;
import com.court.management.response.SuccessResponse;
import com.court.management.service.SignUpService;
import com.court.management.utils.CourtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SignOnServiceImpl implements SignUpService {


    @Autowired
    private SignUpRepoWork signUpRepoWork;

    @Autowired
    private CourtUtils courtUtils;

    @Override
    public SuccessResponse addUsers(SignUpDto signUpDto) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Timestamp filterDateFromTs = new Timestamp ((dateFormat.parse(signUpDto.getDob())).getTime());

        try {
            signUpDto.setUserId(signUpDto.getEmail().split("@")[0]);
            SignUp signUp = courtUtils.signUpDtoToEntity(signUpDto);
            signUp.setActionBy(signUpDto.getUserId());
            signUp.setActionTime(new Timestamp(new Date().getTime()));
            signUp.setStatus(CourtConstants.PENDING);
            log.info("inside service : {}", signUpDto);
            SignUp saveedData = signUpRepoWork.save(signUp);
            return SuccessResponse.builder().status(HttpStatus.OK.value()).message(CourtConstants.SUCCESS).data(courtUtils.signUpEntityToDto(saveedData)).build();
        } catch (Exception e) {
            log.error(e.toString());
            throw new CourtException(e.getMessage());
        }

    }

    @Override
    public SuccessResponse acceptOrRequestUser(AcceptOrRegect acceptOrRegect) {
        return null;
    }

    @Override
    public List<SignUpDto> getAllUserByStatus(String status) {
        return null;
    }

    @Override
    public List<SignUpDto> getAllSignUpReq() {
        try {
            log.info("Inside getallsignupreq");
            return signUpRepoWork.findAll().stream().map(e -> courtUtils.signUpEntityToDto(e)).collect(Collectors.toList());

        } catch (Exception e) {
            log.error(e.toString());
            throw new CourtException(e.getMessage());
        }


    }
}
