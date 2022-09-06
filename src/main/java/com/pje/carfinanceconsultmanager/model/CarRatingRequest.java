package com.pje.carfinanceconsultmanager.model;

import com.pje.carfinanceconsultmanager.entity.CarModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CarRatingRequest {
    @ApiModelProperty(notes = "차량 모델 시퀀스", required = true)
    @NotNull
    private Long carModelId;

    @ApiModelProperty(notes = "차량 등급", required = true)
    @NotNull
    private Double ratingValue; //차량 등급 ex) 2.5 / 2.0 / 3.5 ...

    @ApiModelProperty(notes = "엔진 타입(~10글자)", required = true)
    @NotNull
    @Length(max = 10)
    private String engineType; //엔진 타입 ex) V6 / 직렬4기통 ...

    @ApiModelProperty(notes = "최대 토크", required = true)
    @NotNull
    private Double maximumTorque; //최대 토크 ex) 191.0Nm / 322.0Nm ...

    @ApiModelProperty(notes = "최고 출력", required = true)
    @NotNull
    private Double highestOutput; //최고 출력
}
