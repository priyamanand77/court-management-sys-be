package com.court.management.utils;

import com.court.management.dto.SignUpDto;
import com.court.management.dto.UserTableDto;
import com.court.management.model.SignUp;
import com.court.management.model.UserTable;
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

    public UserTable userTableDtoToEntity(UserTableDto dto)
    {
        return modelMapper.map(dto, UserTable.class);
    }

    public UserTableDto userTableEntityToDto (UserTable entity)
    {
        return modelMapper.map(entity, UserTableDto.class);
    }
}
