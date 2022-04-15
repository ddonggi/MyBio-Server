package com.dglee.service.mybio.server.model;
/*
 * Created by 이동기 on 2022-03-21
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//해당 클래스는 DB Table 과 매핑되는 코어한 클래스이기 때문에, 불변성 보장을 위해 @Setter 는 쓰지 않는다.
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "templates", schema = "public")
public class Template {

    @Id
    @Column(name = "create_no",nullable = false)
    private Long pk;

    private String design;

    @Column(name = "userid")
    private String userId;

    @Column(name = "view_mode")
    private String viewMode;

    @Override
    public String toString() {
        return "{" +
                "pk=" + pk +
                ", design='" + design + '\'' +
                ", viewMode='" + viewMode + '\'' +
                '}';
    }
}
