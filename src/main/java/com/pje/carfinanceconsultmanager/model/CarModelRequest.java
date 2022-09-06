package com.pje.carfinanceconsultmanager.model;

import com.pje.carfinanceconsultmanager.enums.VehicleType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CarModelRequest {
    @ApiModelProperty(notes = "제조사 시퀀스", required = true)
    @NotNull
    private Long manufacturerId; //제조사 시퀀스

    @ApiModelProperty(notes = "차량 모델명(~30글자)", required = true)
    @NotNull
    @Length(max = 30)
    private String modelName; //차량 모델명

    @ApiModelProperty(notes = "차량 외장 타입(~30글자)", required = true)
    @Enumerated(value = EnumType.STRING)
    private VehicleType vehicleType; //차량 외장 타입

    @ApiModelProperty(notes = "차량 정원", required = true)
    @NotNull
    private Double capacity; //차량 정원

    @ApiModelProperty(notes = "차량 전장", required = true)
    @NotNull
    private Double fullLength; //차량 전장

    @ApiModelProperty(notes = "차량 전폭", required = true)
    @NotNull
    private Double fullWidth; //차량 전폭

    @ApiModelProperty(notes = "차량 전고", required = true)
    @NotNull
    private Double fullHeight; //차량 전고

    @ApiModelProperty(notes = "차량 축거", required = true)
    @NotNull
    private Double wheelBase; //차량 축거

    @ApiModelProperty(notes = "차량 윤거(전)", required = true)
    @NotNull
    private Double beforeWheelTrack; //차량 윤거(전)

    @ApiModelProperty(notes = "차량 윤거(후)", required = true)
    @NotNull
    private Double afterWheelTrack; //차량 윤거(후)

    @ApiModelProperty(notes = "전륜 브레이크(~20글자)", required = true)
    @NotNull
    @Length(max = 20)
    private String frontWheelBrake; //전륜 브레이크

    @ApiModelProperty(notes = "후륜 브레이크(~20글자)", required = true)
    @NotNull
    @Length(max = 20)
    private String rearWheelBrake; //후륜 브레이크

    @ApiModelProperty(notes = "전륜 서스펜션(~20글자)", required = true)
    @NotNull
    @Length(max = 20)
    private String frontWheelSuspension; //전륜 서스펜션

    @ApiModelProperty(notes = "후륜 서스펜션(~20글자)", required = true)
    @NotNull
    @Length(max = 20)
    private String rearWheelSuspension; //후륜 서스펜션

    @ApiModelProperty(notes = "파워 스티어링 형식(~20글자)", required = true)
    @NotNull
    @Length(max = 20)
    private String powerSteeringFormat; //파워 스티어링 형식
}
