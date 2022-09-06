package com.pje.carfinanceconsultmanager.repository;

import com.pje.carfinanceconsultmanager.entity.CarTrim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarTrimRepository extends JpaRepository<CarTrim, Long> {
    List<CarTrim> findAllByCarRating_CarModel_Id(Long carModelId);
}
