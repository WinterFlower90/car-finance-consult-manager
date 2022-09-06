package com.pje.carfinanceconsultmanager.service;

import com.pje.carfinanceconsultmanager.entity.CarModel;
import com.pje.carfinanceconsultmanager.entity.Manufacturer;
import com.pje.carfinanceconsultmanager.exception.CMissingDataException;
import com.pje.carfinanceconsultmanager.model.CarModelRequest;
import com.pje.carfinanceconsultmanager.repository.CarModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarModelService {
    private final CarModelRepository carModelRepository;

    public CarModel getCarModelData(long id) {
        return carModelRepository.findById(id).orElseThrow(CMissingDataException::new);
    }

    public void setCarModel(Manufacturer manufacturer, CarModelRequest modelRequest) {
        CarModel carModel = new CarModel.CarModelBuilder(manufacturer, modelRequest).build();
        carModelRepository.save(carModel);
    }
}
