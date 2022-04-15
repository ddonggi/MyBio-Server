package com.dglee.service.mybio.server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*
 * Created by 이동기 on 2022-03-28
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mini_card_data", schema = "public")
public class MiniCard implements Serializable {
    @Id
    Long pk;
    @Column(name="name_ko")
    String koreanName;
    @Column(name="name_en")
    String englishName;
    @Column(name="profile_image")
    String profileImage;
   @Column(name="greetings")
    String greetings;
   @Column(name="introduction")
    String introduction;
   @Column(name="links")
    String links;
   @Column(name="card_id")
   Long cardId;
}
