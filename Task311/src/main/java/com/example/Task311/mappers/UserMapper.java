package com.example.Task311.mappers;

import com.example.Task311.DTO.UserDTO;
import com.example.Task311.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.control.MappingControl;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDTO(User user);
}
