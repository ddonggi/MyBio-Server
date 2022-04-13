package com.dglee.service.mybio.server.DTO;

import lombok.*;

/*
 * Created by 이동기 on 2022-03-21
 */

@Getter
@NoArgsConstructor
@ToString
public class CardDTO {

    private Long showOrder;
    private String type;
    private String style;
    private String cardData;

    @Builder
    public CardDTO(Long showOrder, String type, String style, String cardData) {
        this.showOrder = showOrder;
        this.type = type;
        this.style = style;
        this.cardData = cardData;
    }
}
