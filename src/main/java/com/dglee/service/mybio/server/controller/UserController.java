package com.dglee.service.mybio.server.controller;
/*
 * Created by 이동기 on 2022-03-21
 */

import com.dglee.service.mybio.server.DTO.UserDTO;
import com.dglee.service.mybio.server.repository.UserRepository;
import com.dglee.service.mybio.server.util.ObjectConverter;
import com.dglee.service.mybio.server.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController implements Serializable {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserRepository userRepository;
    private final ObjectConverter objectConverter;


    @Autowired
    public UserController(UserRepository userRepository, ObjectConverter objectConverter) {
        this.userRepository = userRepository;
        this.objectConverter = objectConverter;
    }


    @GetMapping(value = "/info/{userId}")
    public UserDTO getUser(@PathVariable String userId) {
        logger.info("userid:{}", userId);

        User user = userRepository.findByUserId(userId).orElseThrow(NoSuchElementException::new);

        return objectConverter.convertUserToDTO(user);
    }


    //for test
    @GetMapping(value = "/users")
    public List<UserDTO> userList() {
        List<User> userList = userRepository.findAll();

        return objectConverter.convertUserListToDTOList(userList);
    }
}