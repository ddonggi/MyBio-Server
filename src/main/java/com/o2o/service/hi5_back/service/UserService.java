package com.o2o.service.hi5_back.service;
/*
 * Created by 이동기 on 2022-03-21
 */

import com.o2o.service.hi5_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
