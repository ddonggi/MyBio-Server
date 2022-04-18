package com.dglee.service.mybio.server.repository;
/*
 * Created by 이동기 on 2022-03-21
 */


import com.dglee.service.mybio.server.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateRepository extends JpaRepository<Template,String> {
    Template save(Template template);
    Template findByUserId(String userId);
    List<Template> findAllByUserId(String userId);
}
