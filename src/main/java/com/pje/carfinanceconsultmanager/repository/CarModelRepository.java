package com.pje.carfinanceconsultmanager.repository;

import com.pje.carfinanceconsultmanager.entity.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
}
