package com.dglee.service.mybio.server.controller;
/*
 * Created by 이동기 on 2022-03-21
 */

import com.dglee.service.mybio.server.DTO.TemplateDTO;
import com.dglee.service.mybio.server.model.Template;
import com.dglee.service.mybio.server.repository.TemplateRepository;
import com.dglee.service.mybio.server.util.ObjectConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController //를 통해 HTTP 응답 데이터(body) 에 자바 객체가 매핑되어 전달된다.
public class TemplateController {
    private final Logger logger = LoggerFactory.getLogger(CardController.class);
    private final TemplateRepository templateRepository;
    private final ObjectConverter objectConverter;

    @Autowired
    public TemplateController(TemplateRepository templateRepository, ObjectConverter objectConverter) {
        this.templateRepository = templateRepository;
        this.objectConverter = objectConverter;
    }

    @GetMapping("/template/{userId}")
    public TemplateDTO getTemplate(@PathVariable String userId){
        logger.info("template request userId >>{}",userId);
        // DB에 쿼리하여 가져오는 데이터
        Template template = templateRepository.findByUserId(userId);
        // 전송용 데이터
        TemplateDTO templateDTO = objectConverter.convertTemplateToTemplateDTO(template);
        return templateDTO;
    }
}
