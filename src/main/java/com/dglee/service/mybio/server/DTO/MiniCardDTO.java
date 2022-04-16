package com.dglee.service.mybio.server.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * Created by 이동기 on 2022-03-21
 */

@Getter
@NoArgsConstructor
@ToString
public class MiniCardDTO {

    String koreanName;
    String englishName;
    String profileImage;
    String greetings;
    String introduction;
    String links;

    @Builder
    public MiniCardDTO(String koreanName, String englishName, String profileImage, String greetings, String introduction, String links) {
        this.koreanName = koreanName;
        this.englishName = englishName;
        this.profileImage = profileImage;
        this.greetings = greetings;
        this.introduction = introduction;
        this.links = links;
    }

}
