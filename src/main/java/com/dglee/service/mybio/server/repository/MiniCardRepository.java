package com.dglee.service.mybio.server.repository;
/*
 * Created by 이동기 on 2022-03-28
 */

import com.dglee.service.mybio.server.model.MiniCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface MiniCardRepository extends JpaRepository<MiniCard, String>, Serializable {
    MiniCard save(MiniCard MiniCard);
    MiniCard findMiniCardByCardId(String cardId);
}
