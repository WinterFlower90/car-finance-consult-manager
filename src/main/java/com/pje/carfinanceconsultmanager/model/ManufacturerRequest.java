package com.pje.carfinanceconsultmanager.model;

import com.pje.carfinanceconsultmanager.enums.ManufacturerCompany;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ManufacturerRequest {
    @ApiModelProperty(notes = "차량 제조사", required = true)
    @NotNull
    private ManufacturerCompany manufacturerCompany;

    @ApiModelProperty(notes = "차량 제조사 로고 uri", required = false)
    private String manufacturerLogoUri;
}
