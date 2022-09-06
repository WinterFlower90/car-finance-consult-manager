package com.pje.carfinanceconsultmanager.service;

import com.pje.carfinanceconsultmanager.entity.CarModel;
import com.pje.carfinanceconsultmanager.entity.CarRating;
import com.pje.carfinanceconsultmanager.exception.CMissingDataException;
import com.pje.carfinanceconsultmanager.model.CarRatingRequest;
import com.pje.carfinanceconsultmanager.repository.CarRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarRatingService {
    private final CarRatingRepository carRatingRepository;

    public CarRating getCarRatingData(long id) {
        return carRatingRepository.findById(id).orElseThrow(CMissingDataException::new);
    }

    public void setCarRating(CarModel carModel, CarRatingRequest request) {
        CarRating carRating = new CarRating.CarRatingBuilder(carModel, request).build();
        carRatingRepository.save(carRating);
    }
}
