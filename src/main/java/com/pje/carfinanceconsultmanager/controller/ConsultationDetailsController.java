package com.pje.carfinanceconsultmanager.controller;

import com.pje.carfinanceconsultmanager.entity.CarTrim;
import com.pje.carfinanceconsultmanager.model.CommonResult;
import com.pje.carfinanceconsultmanager.model.ConsultationDetailsItem;
import com.pje.carfinanceconsultmanager.model.ConsultationDetailsRequest;
import com.pje.carfinanceconsultmanager.model.ListResult;
import com.pje.carfinanceconsultmanager.service.CarInfoService;
import com.pje.carfinanceconsultmanager.service.ConsultationDetailsService;
import com.pje.carfinanceconsultmanager.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

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

    @ApiOperation(value = "상담 내역 기간별 리스트 가져오기")
    @GetMapping("/search")
    public ListResult<ConsultationDetailsItem> getConsultationDetails(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "dateStart")LocalDate dateStart,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "dateEnd") LocalDate dateEnd
            ) {
        return ResponseService.getListResult(consultationDetailsService.getConsultationDetails(dateStart, dateEnd), true);
    }



}
