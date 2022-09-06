package com.pje.carfinanceconsultmanager.model;

import com.pje.carfinanceconsultmanager.entity.CarRating;
import com.pje.carfinanceconsultmanager.enums.DriveMethod;
import com.pje.carfinanceconsultmanager.enums.FuelType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CarTrimRequest {
    @ApiModelProperty(notes = "차량 등급 시퀀스", required = true)
    @NotNull
    private Long carRatingId;

    @ApiModelProperty(notes = "차량 트림명(~20글자)", required = true)
    @NotNull
    @Length(max = 20)
    private String trimName;

    @ApiModelProperty(notes = "차량 구동방식(~10글자)", required = true)
    @Enumerated(value = EnumType.STRING)
    private DriveMethod driveMethod;

    @ApiModelProperty(notes = "차량 연료 타입(~15글자)", required = true)
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType;

    @ApiModelProperty(notes = "차량 배기량", required = true)
    @NotNull
    private Double engineDisplacement;

    @ApiModelProperty(notes = "차량 가격", required = true)
    @NotNull
    private Double carPrice;

    @ApiModelProperty(notes = "공차 중량", required = true)
    @NotNull
    private Double toleranceWeight;

    @ApiModelProperty(notes = "앞타이어 규격(~20글자)", required = true)
    @NotNull
    @Length(max = 20)
    private String frontTireSpecification;

    @ApiModelProperty(notes = "뒷타이어 규격(~20글자)", required = true)
    @NotNull
    @Length(max = 20)
    private String rearTireSpecification;

    @ApiModelProperty(notes = "복합 연비", required = true)
    @NotNull
    private Double combinedFuelEconomy;

    @ApiModelProperty(notes = "도심 연비", required = true)
    @NotNull
    private Double cityFuelEconomy;

    @ApiModelProperty(notes = "고속도로 연비", required = true)
    @NotNull
    private Double highwayFuelEconomy;

    @ApiModelProperty(notes = "연비 등급", required = true)
    @NotNull
    private Double fuelEconomyRating;

    @ApiModelProperty(notes = "Co2 배출량", required = true)
    @NotNull
    private Double emissionsCo2;

    @ApiModelProperty(notes = "제로백", required = false)
    private Double zero100;

    @ApiModelProperty(notes = "자율주행 레벨", required = false)
    private Double selfDrivingLevel;

    @ApiModelProperty(notes = "저공해 등급", required = false)
    private Double lowPollutionGrade;
}
