package com.pje.carfinanceconsultmanager.service;

import com.pje.carfinanceconsultmanager.entity.CarTrim;
import com.pje.carfinanceconsultmanager.entity.ConsultationDetails;
import com.pje.carfinanceconsultmanager.model.ConsultationDetailsRequest;
import com.pje.carfinanceconsultmanager.repository.ConsultationDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultationDetailsService {
    private final ConsultationDetailsRepository consultationDetailsRepository;

    public void setConsultationDetails(CarTrim carTrim, ConsultationDetailsRequest request) {
        ConsultationDetails consultationDetails = new ConsultationDetails.ConsultationDetailsBuilder(carTrim, request).build();
        consultationDetailsRepository.save(consultationDetails);
    }
}
