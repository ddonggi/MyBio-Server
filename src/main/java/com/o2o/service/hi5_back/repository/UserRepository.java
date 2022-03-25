package com.o2o.service.hi5_back.repository;
/*
 * Created by 이동기 on 2022-03-21
 */

import com.o2o.service.hi5_back.DTO.UserDTO;
import com.o2o.service.hi5_back.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, Serializable {
    User save(User user);
    Optional<User> findByUserId(String userId);
    List<User> findAll();
}
