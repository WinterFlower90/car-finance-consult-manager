package com.pje.carfinanceconsultmanager.service;

import com.pje.carfinanceconsultmanager.entity.CarTrim;
import com.pje.carfinanceconsultmanager.entity.ConsultationDetails;
import com.pje.carfinanceconsultmanager.model.ConsultationDetailsItem;
import com.pje.carfinanceconsultmanager.model.ConsultationDetailsRequest;
import com.pje.carfinanceconsultmanager.model.ListResult;
import com.pje.carfinanceconsultmanager.repository.ConsultationDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultationDetailsService {
    private final ConsultationDetailsRepository consultationDetailsRepository;

    public void setConsultationDetails(CarTrim carTrim, ConsultationDetailsRequest request) {
        ConsultationDetails consultationDetails = new ConsultationDetails.ConsultationDetailsBuilder(carTrim, request).build();
        consultationDetailsRepository.save(consultationDetails);
    }

    public ListResult<ConsultationDetailsItem> getConsultationDetails(LocalDate dateStart, LocalDate dateEnd) {
        LocalDateTime dateStartTime = LocalDateTime.of(
                dateStart.getYear(),
                dateStart.getMonthValue(),
                dateStart.getDayOfMonth(),
                0,0,0
        );
        LocalDateTime dateEndTime = LocalDateTime.of(
                dateEnd.getYear(),
                dateEnd.getMonthValue(),
                dateEnd.getDayOfMonth(),
                23,59,59
        );

        List<ConsultationDetails> consultationDetails = consultationDetailsRepository.findAllByDateConsultGreaterThanEqualAndDateConsultLessThanEqualOrderByIdDesc(dateStartTime, dateEndTime);

        List<ConsultationDetailsItem> result = new LinkedList<>();
        consultationDetails.forEach(consultationDetail -> {
            ConsultationDetailsItem addItem = new ConsultationDetailsItem.ConsultationDetailsItemBuilder(consultationDetail).build();
            result.add(addItem);
        });

        return ListConvertService.settingResult(result);
    }
}
