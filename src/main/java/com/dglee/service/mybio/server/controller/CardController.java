package com.dglee.service.mybio.server.controller;
/*
 * Created by 이동기 on 2022-03-21
 */

import com.dglee.service.mybio.server.DTO.CardDTO;
import com.dglee.service.mybio.server.model.Card;
import com.dglee.service.mybio.server.repository.CardRepository;
import com.dglee.service.mybio.server.repository.MiniCardRepository;
import com.dglee.service.mybio.server.util.ObjectConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
public class CardController implements Serializable {
    private final Logger logger = LoggerFactory.getLogger(CardController.class);
    private final CardRepository cardRepository;
    private final MiniCardRepository miniCardRepository;
    private final ObjectConverter objectConverter;

    @Autowired
    public CardController(CardRepository cardRepository, MiniCardRepository miniCardRepository, ObjectConverter objectConverter) {
        this.cardRepository = cardRepository;
        this.miniCardRepository = miniCardRepository;
        this.objectConverter = objectConverter;
    }
    @GetMapping(value = "/card/{userId}")
    public List<CardDTO> getCard(@PathVariable String userId){
        logger.info("card request userId >>{}",userId);
        // DB에 쿼리하여 가져오는 데이터
        List<Card> cardList = cardRepository.findCardByUserIdOrderByShowOrder(userId);
        // 전송용 데이터
        List<CardDTO> cardDTOList = objectConverter.convertCardListToDTOList(cardList);
        return cardDTOList;
    }

/*    @GetMapping(value = "/mini-card/{cardId}")
    public MiniCardDTO getMiniCard(@PathVariable String cardId){
        logger.info("request mini card >>");
        logger.info("cardId:{}",cardId);
        // DB에 쿼리하여 가져오는 데이터
        MiniCard MiniCard = miniCardRepository.findMiniCardByCardId(cardId);
        // 전송용 데이터
        MiniCardDTO miniCardDTO= objectConverter.convertMiniCardToMiniCardDTO(MiniCard);
        return miniCardDTO;
    }*/

}
