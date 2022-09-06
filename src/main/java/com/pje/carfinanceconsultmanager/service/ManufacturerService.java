package com.pje.carfinanceconsultmanager.service;

import com.pje.carfinanceconsultmanager.entity.Manufacturer;
import com.pje.carfinanceconsultmanager.exception.CMissingDataException;
import com.pje.carfinanceconsultmanager.model.ManufacturerRequest;
import com.pje.carfinanceconsultmanager.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    public Manufacturer getManufacturerData(long id) {
        return manufacturerRepository.findById(id).orElseThrow(CMissingDataException::new);
    }

    public void setManufacturer(ManufacturerRequest request) {
        Manufacturer manufacturer = new Manufacturer.ManufacturerBuilder(request).build();
        manufacturerRepository.save(manufacturer);
    }
}
