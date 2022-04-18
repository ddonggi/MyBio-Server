package com.dglee.service.mybio.server.util;
/*
 * Created by 이동기 on 2022-03-23
 */

import com.dglee.service.mybio.server.DTO.CardDTO;
import com.dglee.service.mybio.server.DTO.MiniCardDTO;
import com.dglee.service.mybio.server.DTO.TemplateDTO;
import com.dglee.service.mybio.server.DTO.UserDTO;
import com.dglee.service.mybio.server.model.Card;
import com.dglee.service.mybio.server.model.MiniCard;
import com.dglee.service.mybio.server.model.Template;
import com.dglee.service.mybio.server.model.User;
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
                    .cardId(card.getPk())
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

    public MiniCardDTO convertMiniCardToMiniCardDTO(MiniCard miniCard) {
        return MiniCardDTO.builder()
                .koreanName(miniCard.getKoreanName())
                .englishName(miniCard.getEnglishName())
                .profileImage(miniCard.getProfileImage())
                .greetings(miniCard.getGreetings())
                .introduction(miniCard.getIntroduction())
                .links(miniCard.getLinks())
                .build();
    }

    public TemplateDTO convertTemplateToTemplateDTO(Template template) {
        TemplateDTO templateDTO = TemplateDTO.builder()
                .design(template.getDesign())
                .viewMode(template.getViewMode())
                .build();
        logger.info("templateDTO:{}", templateDTO.toString());
        return templateDTO;
    }
}
