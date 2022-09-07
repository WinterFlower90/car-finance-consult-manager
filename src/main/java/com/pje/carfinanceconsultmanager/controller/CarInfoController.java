package com.pje.carfinanceconsultmanager.controller;

import com.pje.carfinanceconsultmanager.entity.CarModel;
import com.pje.carfinanceconsultmanager.entity.CarRating;
import com.pje.carfinanceconsultmanager.entity.Manufacturer;
import com.pje.carfinanceconsultmanager.model.*;
import com.pje.carfinanceconsultmanager.service.CarInfoService;
import com.pje.carfinanceconsultmanager.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "차량 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/V1/car-info")
public class CarInfoController {
    private final CarInfoService carInfoService;

    @ApiOperation(value = "제조사 정보 등록하기")
    @PostMapping("/new/carManufacturer")
    public CommonResult setManufacturer(@RequestBody @Valid ManufacturerRequest request) {
        carInfoService.setManufacturer(request);
        return ResponseService.getSuccessResult();
    }

    @ApiOperation(value = "자동차 모델 정보 등록하기")
    @PostMapping("/new/carModel")
    public CommonResult setCarModel(@RequestBody @Valid CarModelRequest request) {
        Manufacturer manufacturer = carInfoService.getManufacturerData(request.getManufacturerId());
        carInfoService.setCarModel(manufacturer, request);
        return ResponseService.getSuccessResult();
    }

    @ApiOperation(value = "자동차 등급 정보 등록하기")
    @PostMapping("/new/carRating")
    public CommonResult setCarRating(@RequestBody @Valid CarRatingRequest request) {
        CarModel carModel = carInfoService.getCarModelData(request.getCarModelId());
        carInfoService.setCarRating(carModel, request);
        return ResponseService.getSuccessResult();
    }

    @ApiOperation(value = "자동차 트림 정보 등록하기")
    @PostMapping("/new/carTrim")
    public CommonResult setCarTrim(@RequestBody @Valid CarTrimRequest request) {
        CarRating carRating = carInfoService.getCarRatingData(request.getCarRatingId());
        carInfoService.setCarTrim(carRating, request);
        return ResponseService.getSuccessResult();
    }

    @ApiOperation(value = "자동차 모델 리스트 가져오기")
    @GetMapping("/model/all")
    public ListResult<CarListItem> getCarModels() {
        return ResponseService.getListResult(carInfoService.getCarModels(), true);
    }

    @ApiOperation(value = "차량 정보 가져오기")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "모델 시퀀스", required = true)
    })
    @GetMapping("/detail/car-model-id/{carModelId}")
    public SingleResult<CarInfoDetailResponse> getDetail(@PathVariable long carModelId) {
        return ResponseService.getSingleResult(carInfoService.getDetail(carModelId));
    }

    @ApiOperation(value = "제조사 정보 수정하기")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "제조사 시퀀스", required = true)
    })
    @PutMapping("/carManufacturer/{manufacturerId}")
    public CommonResult putManufacturer(@PathVariable long manufacturerId, @RequestBody @Valid ManufacturerRequest request) {
        carInfoService.putManufacturer(manufacturerId, request);
        return ResponseService.getSuccessResult();
    }
}
