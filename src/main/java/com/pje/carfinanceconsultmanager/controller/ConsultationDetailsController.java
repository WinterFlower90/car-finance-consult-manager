package com.pje.carfinanceconsultmanager.controller;

import com.pje.carfinanceconsultmanager.entity.CarTrim;
import com.pje.carfinanceconsultmanager.model.CommonResult;
import com.pje.carfinanceconsultmanager.model.ConsultationDetailsRequest;
import com.pje.carfinanceconsultmanager.service.CarInfoService;
import com.pje.carfinanceconsultmanager.service.ConsultationDetailsService;
import com.pje.carfinanceconsultmanager.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "차량 상담 내역 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/V1/consult-detail")
public class ConsultationDetailsController {
    private final ConsultationDetailsService consultationDetailsService;
    private final CarInfoService carInfoService;

    @ApiOperation(value = "자동차 상담 내역 등록하기")
    @PostMapping("/new")
    public CommonResult setConsultDetail(@RequestBody @Valid ConsultationDetailsRequest request) {
        CarTrim carTrim = carInfoService.getCarTrimData(request.getCarTrimId());
        consultationDetailsService.setConsultationDetails(carTrim, request);
        return ResponseService.getSuccessResult();
    }

}
