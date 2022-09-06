package com.pje.carfinanceconsultmanager.controller;

import com.pje.carfinanceconsultmanager.service.ConsultationDetailsService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "차량 상담 내역 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/V1/consult-detail")
public class ConsultationDetailsController {
    private final ConsultationDetailsService consultationDetailsService;

}
