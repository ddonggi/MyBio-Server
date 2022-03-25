package com.o2o.service.hi5_back.model;
/*
 * Created by 이동기 on 2022-03-21
 */

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

//해당 클래스는 DB Table 과 매핑되는 코어한 클래스이기 때문에, 불변성 보장을 위해 @Setter 는 쓰지 않는다.
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Builder
@ToString
@Table(name = "user", schema = "public")
public class User implements Serializable {

    @Id
    @Column(name="pk",nullable = false)
    private Long pk;

    @Column(name = "user_id",nullable = false)
    private String userId;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

}
