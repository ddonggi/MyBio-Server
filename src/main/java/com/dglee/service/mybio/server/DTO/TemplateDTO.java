package com.dglee.service.mybio.server.DTO;
/*
 * Created by 이동기 on 2022-03-21
 */

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class TemplateDTO {
    private String design;
    private String viewMode;

    @Builder
    public TemplateDTO(String design, String viewMode) {
        this.design = design;
        this.viewMode = viewMode;
    }
}
