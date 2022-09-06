package com.pje.carfinanceconsultmanager.controller;

import com.pje.carfinanceconsultmanager.model.CommonResult;
import com.pje.carfinanceconsultmanager.model.ManufacturerRequest;
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

@Api(tags = "제조사 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/V1/manufacturer")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @ApiOperation(value = "제조사 정보 등록하기")
    @PostMapping("/new")
    public CommonResult setManufacturer(@RequestBody @Valid ManufacturerRequest request) {
        manufacturerService.setManufacturer(request);
        return ResponseService.getSuccessResult();
    }
}
