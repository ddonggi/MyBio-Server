package com.o2o.service.hi5_back.repository;
/*
 * Created by 이동기 on 2022-03-21
 */


import com.o2o.service.hi5_back.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, String>, Serializable {
    Card save(Card card);
    List<Card> findCardByUserIdOrderByShowOrder(String userId);
    List<Card> findAllByUserId(String userId);
}
