package com.elkabani.mydb.mappers;

import com.elkabani.mydb.dtos.RegisterUserRequest;
import com.elkabani.mydb.dtos.UpdateUserRequest;
import com.elkabani.mydb.dtos.UserDto;
import com.elkabani.mydb.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);
}
