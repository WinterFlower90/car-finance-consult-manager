package com.pje.carfinanceconsultmanager.controller;

import com.pje.carfinanceconsultmanager.entity.CarRating;
import com.pje.carfinanceconsultmanager.entity.Manufacturer;
import com.pje.carfinanceconsultmanager.model.CarModelRequest;
import com.pje.carfinanceconsultmanager.model.CarTrimRequest;
import com.pje.carfinanceconsultmanager.model.CommonResult;
import com.pje.carfinanceconsultmanager.service.CarModelService;
import com.pje.carfinanceconsultmanager.service.ManufacturerService;
import com.pje.carfinanceconsultmanager.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "자동차 모델 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/V1/car-model")
public class CarModelController {
    private final CarModelService carModelService;
    private final ManufacturerService manufacturerService;

    @ApiOperation(value = "자동차 모델 정보 등록하기")
    @PostMapping("/new")
    public CommonResult setCarModel(@RequestBody @Valid CarModelRequest request) {
        Manufacturer manufacturer = manufacturerService.getManufacturerData(request.getManufacturerId());
        carModelService.setCarModel(manufacturer, request);
        return ResponseService.getSuccessResult();
    }
}
