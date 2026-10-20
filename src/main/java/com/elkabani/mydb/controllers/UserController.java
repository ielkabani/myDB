package com.elkabani.mydb.controllers;

import com.elkabani.mydb.dtos.UserDto;
import com.elkabani.mydb.entities.User;
import com.elkabani.mydb.mappers.UserMapper;
import com.elkabani.mydb.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController

@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    public Iterable<UserDto>  getAllUsers(
            @RequestHeader(name="x-auth-token", required = false) String authToken,
            @RequestParam(required = false, defaultValue = "name") String sort)
    {
        System.out.println("Auth Token: " + authToken);
        return userRepository.findAll(Sort.by(sort)).stream()
                .map(user -> userMapper.toDto(user))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id)

    {
        var user = userRepository.findById(id).orElse(null);
        if(user==null){
            return ResponseEntity.notFound().build();
        }

     //   var userDto = new UserDto(user.getId(), user.getName(), user.getEmail());
        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
