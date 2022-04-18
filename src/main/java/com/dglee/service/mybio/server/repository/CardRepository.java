package com.dglee.service.mybio.server.repository;
/*
 * Created by 이동기 on 2022-03-21
 */


import com.dglee.service.mybio.server.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, String>, Serializable {
    Card save(Card card);
    List<Card> findCardByUserIdOrderByShowOrder(String userId);
    List<Card> findAllByUserId(String userId);
}
