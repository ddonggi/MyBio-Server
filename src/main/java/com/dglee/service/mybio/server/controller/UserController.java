package com.dglee.service.mybio.server.controller;
/*
 * Created by 이동기 on 2022-03-21
 */

import com.dglee.service.mybio.server.DTO.UserDTO;
import com.dglee.service.mybio.server.model.User;
import com.dglee.service.mybio.server.repository.UserRepository;
import com.dglee.service.mybio.server.util.ObjectConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

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
    public ResponseEntity<UserDTO> getUser(@PathVariable String userId) {
        logger.info("userid:{}", userId);

/*        Optional<User> user = Optional.of(userRepository.findByUserId(userId).orElse(new User()));

        logger.info("ss");
        return objectConverter.convertUserToDTO(user);*/
        if(userRepository.findByUserId(userId)==null){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }else{
            User user = userRepository.findByUserId(userId);
            UserDTO userDTO = objectConverter.convertUserToDTO(user);

            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        }

    }


    //for test
    @GetMapping(value = "/users")
    public List<UserDTO> userList() {
        List<User> userList = userRepository.findAll();

        return objectConverter.convertUserListToDTOList(userList);
    }
}
