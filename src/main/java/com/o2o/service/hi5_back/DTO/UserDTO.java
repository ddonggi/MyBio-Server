package com.o2o.service.hi5_back.DTO;
/*
 * Created by 이동기 on 2022-03-21
 */

import lombok.*;

import java.util.UUID;

@Getter
@NoArgsConstructor
@ToString
public class UserDTO {

    private String userId;
    private String email;

    @Builder
    public UserDTO(String userId,String email){
        this.userId = userId;
        this.email = email;
    }

}
