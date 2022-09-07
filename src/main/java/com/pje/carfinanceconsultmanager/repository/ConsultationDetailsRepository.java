package com.pje.carfinanceconsultmanager.repository;

import com.pje.carfinanceconsultmanager.entity.ConsultationDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultationDetailsRepository extends JpaRepository<ConsultationDetails, Long> {

    List<ConsultationDetails> findAllByDateConsultGreaterThanEqualAndDateConsultLessThanEqualOrderByIdDesc(LocalDateTime dateStart, LocalDateTime dateEnd);
}
