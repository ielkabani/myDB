package com.elkabani.mydb.mappers;

import com.elkabani.mydb.dtos.UserDto;
import com.elkabani.mydb.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
