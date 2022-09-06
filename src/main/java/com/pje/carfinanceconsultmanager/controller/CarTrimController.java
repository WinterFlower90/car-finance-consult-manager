package com.pje.carfinanceconsultmanager.controller;

import com.pje.carfinanceconsultmanager.entity.CarRating;
import com.pje.carfinanceconsultmanager.model.CarTrimRequest;
import com.pje.carfinanceconsultmanager.model.CommonResult;
import com.pje.carfinanceconsultmanager.service.CarRatingService;
import com.pje.carfinanceconsultmanager.service.CarTrimService;
import com.pje.carfinanceconsultmanager.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "자동차 트림 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/V1/car-trim")
public class CarTrimController {
    private final CarTrimService carTrimService;
    private final CarRatingService carRatingService;

    @ApiOperation(value = "자동차 트림 정보 등록하기")
    @PostMapping("/new")
    public CommonResult setCarTrim(@RequestBody @Valid CarTrimRequest request) {
        CarRating carRating = carRatingService.getCarRatingData(request.getCarRatingId());
        carTrimService.setCarTrim(carRating, request);
        return ResponseService.getSuccessResult();
    }
}
