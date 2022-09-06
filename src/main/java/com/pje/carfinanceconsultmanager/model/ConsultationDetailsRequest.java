package com.pje.carfinanceconsultmanager.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ConsultationDetailsRequest {
    @ApiModelProperty(notes = "차량 트림 시퀀스", required = true)
    @NotNull
    private Long carTrimId;

    @ApiModelProperty(notes = "상담 고객명(~20글자)", required = true)
    @NotNull
    @Length(max = 20)
    private String memberName;

    @ApiModelProperty(notes = "상담 고객 연락처(~15글자)", required = true)
    @NotNull
    @Length(max = 15)
    private String memberPhone;
}
