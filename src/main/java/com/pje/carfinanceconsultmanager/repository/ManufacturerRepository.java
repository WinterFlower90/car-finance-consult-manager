package com.pje.carfinanceconsultmanager.repository;

import com.pje.carfinanceconsultmanager.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
