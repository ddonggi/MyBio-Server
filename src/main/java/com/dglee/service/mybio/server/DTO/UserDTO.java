package com.dglee.service.mybio.server.DTO;
/*
 * Created by 이동기 on 2022-03-21
 */

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
