package com.pje.carfinanceconsultmanager.service;

import com.pje.carfinanceconsultmanager.entity.CarRating;
import com.pje.carfinanceconsultmanager.entity.CarTrim;
import com.pje.carfinanceconsultmanager.exception.CMissingDataException;
import com.pje.carfinanceconsultmanager.model.CarTrimRequest;
import com.pje.carfinanceconsultmanager.repository.CarTrimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarTrimService {
    private final CarTrimRepository carTrimRepository;

    public CarTrim getCarTrimData(long id) {
        return carTrimRepository.findById(id).orElseThrow(CMissingDataException::new);
    }

    public void setCarTrim(CarRating carRating, CarTrimRequest request) {
        CarTrim carTrim = new CarTrim.CarTrimBuilder(carRating, request).build();
        carTrimRepository.save(carTrim);
    }
}
