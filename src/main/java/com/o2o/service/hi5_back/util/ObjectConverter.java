package com.o2o.service.hi5_back.util;
/*
 * Created by 이동기 on 2022-03-23
 */

import com.o2o.service.hi5_back.DTO.CardDTO;
import com.o2o.service.hi5_back.DTO.UserDTO;
import com.o2o.service.hi5_back.controller.UserController;
import com.o2o.service.hi5_back.model.Card;
import com.o2o.service.hi5_back.model.User;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ObjectConverter {
    private final Logger logger = LoggerFactory.getLogger(ObjectConverter.class);
    private final ModelMapper modelMapper = new ModelMapper();

    public UserDTO convertUserToDTO(User user) {
//        UserDTO userDTO = new UserDTO();
//        modelMapper.map(user,userDTO);
        UserDTO userDTO = UserDTO.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .build();
        logger.info("UserDTO:{}", userDTO.toString());
        return userDTO;
    }

    public List<UserDTO> convertUserListToDTOList(List<User> userList) {
        //보내줄 데이터는 builder pattern or setter 으로 특정 정보만 담아줄 수 있다.
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            UserDTO userDTO = UserDTO.builder()
                    .userId(user.getUserId())
                    .email(user.getEmail())
                    .build();
            userDTOList.add(userDTO);
        }
        logger.info("UserDTOList:{}", userDTOList.toString());
        return userDTOList;
    }

    public List<CardDTO> convertCardListToDTOList(List<Card> cardList) {
        List<CardDTO> cardDTOList = new ArrayList<>();
        for (Card card : cardList) {
            CardDTO cardDTO = CardDTO.builder()
                    .showOrder(card.getShowOrder())
                    .type(card.getType())
                    .style(card.getStyle())
                    .cardData(card.getCardData())
                    .build();

            cardDTOList.add(cardDTO);
        }
        logger.info("CardDTOList:{}", cardDTOList.toString());
        return cardDTOList;
    }
}
