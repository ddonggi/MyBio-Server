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
import java.io.Serializable;

//해당 클래스는 DB Table 과 매핑되는 코어한 클래스이기 때문에, 불변성 보장을 위해 @Setter 는 쓰지 않는다.
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cards", schema = "public")
public class Card implements Serializable {

    @Id
    @Column(name="create_no",nullable = false)
    private Long pk;

    @Column(name = "show_order")
    private Long showOrder;

    @Column(name = "type")
    private String type;

    @Column(name = "style")
    private String style;

    @Column(name = "userid")
    private String userId;

    @Column(name="data")
    private String cardData;

/*    @ManyToOne
	@JoinColumn(name = "user_id")
	private User user;*/

    @Override
    public String toString() {
        return "{" +
                "pk=" + pk +
                ", showOrder=" + showOrder +
                ", type='" + type + '\'' +
                ", style='" + style + '\'' +
                ", userId='" + userId + '\'' +
                ", cardData='" + cardData + '\'' +
                '}';
    }

}
