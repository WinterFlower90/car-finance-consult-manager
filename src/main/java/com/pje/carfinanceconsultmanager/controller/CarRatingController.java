package com.pje.carfinanceconsultmanager.controller;

import com.pje.carfinanceconsultmanager.entity.CarModel;
import com.pje.carfinanceconsultmanager.entity.CarRating;
import com.pje.carfinanceconsultmanager.entity.Manufacturer;
import com.pje.carfinanceconsultmanager.model.CarModelRequest;
import com.pje.carfinanceconsultmanager.model.CarRatingRequest;
import com.pje.carfinanceconsultmanager.model.CommonResult;
import com.pje.carfinanceconsultmanager.service.CarModelService;
import com.pje.carfinanceconsultmanager.service.CarRatingService;
import com.pje.carfinanceconsultmanager.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "자동차 등급 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/V1/car-rating")
public class CarRatingController {
    private final CarModelService carModelService;
    private final CarRatingService carRatingService;

    @ApiOperation(value = "자동차 등급 정보 등록하기")
    @PostMapping("/new")
    public CommonResult setCarRating(@RequestBody @Valid CarRatingRequest request) {
        CarModel carModel = carModelService.getCarModelData(request.getCarModelId());
        carRatingService.setCarRating(carModel, request);
        return ResponseService.getSuccessResult();
    }
}
