package com.court.management.utils;

import com.court.management.dto.SignUpDto;
import com.court.management.model.SignUp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourtUtils {

    @Autowired
    private ModelMapper modelMapper;

    public SignUp signUpDtoToEntity(SignUpDto dto) {
        return modelMapper.map(dto, SignUp.class);
    }

    public SignUpDto signUpEntityToDto(SignUp entity) {
        return modelMapper.map(entity, SignUpDto.class);
    }
}
