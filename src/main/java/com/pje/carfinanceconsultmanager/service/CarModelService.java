package com.pje.carfinanceconsultmanager.service;

import com.pje.carfinanceconsultmanager.entity.CarModel;
import com.pje.carfinanceconsultmanager.entity.Manufacturer;
import com.pje.carfinanceconsultmanager.exception.CMissingDataException;
import com.pje.carfinanceconsultmanager.model.CarListItem;
import com.pje.carfinanceconsultmanager.model.CarModelRequest;
import com.pje.carfinanceconsultmanager.model.ListResult;
import com.pje.carfinanceconsultmanager.repository.CarModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

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

    public ListResult<CarListItem> getCarModels() {
        List<CarModel> carModels = carModelRepository.findAll();
        List<CarListItem> result = new LinkedList<>();

        carModels.forEach(carModel -> {
            CarListItem addItem = new CarListItem.CarListItemBuilder(carModel).build();
            result.add(addItem);
        });
        return ListConvertService.settingResult(result);
    }
}
