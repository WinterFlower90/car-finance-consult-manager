package com.pje.carfinanceconsultmanager.service;

import com.pje.carfinanceconsultmanager.entity.CarModel;
import com.pje.carfinanceconsultmanager.entity.CarRating;
import com.pje.carfinanceconsultmanager.entity.CarTrim;
import com.pje.carfinanceconsultmanager.entity.Manufacturer;
import com.pje.carfinanceconsultmanager.exception.CMissingDataException;
import com.pje.carfinanceconsultmanager.model.*;
import com.pje.carfinanceconsultmanager.repository.CarModelRepository;
import com.pje.carfinanceconsultmanager.repository.CarRatingRepository;
import com.pje.carfinanceconsultmanager.repository.CarTrimRepository;
import com.pje.carfinanceconsultmanager.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CarInfoService {
    private final ManufacturerRepository manufacturerRepository;
    private final CarModelRepository carModelRepository;
    private final CarRatingRepository carRatingRepository;
    private final CarTrimRepository carTrimRepository;

    /*
    단독 동작이 힘들게 연결되어 있기 떄문에 하나의 서비스로 뭉치는게 옳다.
     */

    public CarInfoDetailResponse getDetail(long modelId) {
        CarModel carModel = carModelRepository.findById(modelId).orElseThrow(CMissingDataException::new);

        List<CarTrim> trims = carTrimRepository.findAllByCarRating_CarModel_Id(carModel.getId());

        //차량 가격
        ArrayList<Double> prices = new ArrayList<>();
        trims.forEach(trim -> {
            prices.add(trim.getCarPrice());
        });

        prices.sort(Collections.reverseOrder()); //내림차순 정렬

        Double maxPrice = prices.get(0);
        Double minPrice = prices.get(prices.size() - 1);

        //연료 타입 리스트
        List<String> carFuelTypes = new LinkedList<>();
        trims.forEach(trim -> {
            carFuelTypes.add(trim.getFuelType().getName());
        });
        Set<String> tempSet = new HashSet<>(carFuelTypes);
        List<String> carFuelTypesResult = new ArrayList<>(tempSet);

        //배기량
        ArrayList<Integer> displacement = new ArrayList<>();
        trims.forEach(trim -> {
            displacement.add(trim.getEngineDisplacement());
        });

        displacement.sort(Collections.reverseOrder());

        Integer maxDisplacement = displacement.get(0);
        Integer minDisplacement = displacement.get(displacement.size() - 1);

        //연비
        ArrayList<Double> fuelEfficiency = new ArrayList<>();
        trims.forEach(trim -> {
            fuelEfficiency.add(trim.getCombinedFuelEconomy());  //복합 연비
            fuelEfficiency.add(trim.getCityFuelEconomy()); //도심 연비
            fuelEfficiency.add(trim.getHighwayFuelEconomy()); //고속도로 연비
        });

        fuelEfficiency.sort(Collections.reverseOrder());

        Double maxFuelEfficiency = fuelEfficiency.get(0);
        Double minFuelEfficiency = fuelEfficiency.get(fuelEfficiency.size() - 1);

        //정원
        List<Integer> capacity = new ArrayList<>();
        trims.forEach(trim -> {
            capacity.add(carModel.getCapacity());
        });

        capacity.sort(Collections.reverseOrder());

        Integer maxCapacity = capacity.get(0);
        Integer minCapacity = capacity.get(capacity.size() - 1);

        return new CarInfoDetailResponse.CarInfoDetailResponseBuilder(
                carModel,
                minPrice,
                maxPrice,
                carFuelTypesResult,
                minDisplacement,
                maxDisplacement,
                minFuelEfficiency,
                maxFuelEfficiency,
                minCapacity,
                maxCapacity).build();
    }

    public Manufacturer getManufacturerData(long id) {
        return manufacturerRepository.findById(id).orElseThrow(CMissingDataException::new);
    }

    public CarModel getCarModelData(long id) {
        return carModelRepository.findById(id).orElseThrow(CMissingDataException::new);
    }

    public CarRating getCarRatingData(long id) {
        return carRatingRepository.findById(id).orElseThrow(CMissingDataException::new);
    }

    public CarTrim getCarTrimData(long id) {
        return carTrimRepository.findById(id).orElseThrow(CMissingDataException::new);
    }

    public void setManufacturer(ManufacturerRequest request) {
        Manufacturer manufacturer = new Manufacturer.ManufacturerBuilder(request).build();
        manufacturerRepository.save(manufacturer);
    }

    public void setCarModel(Manufacturer manufacturer, CarModelRequest modelRequest) {
        CarModel carModel = new CarModel.CarModelBuilder(manufacturer, modelRequest).build();
        carModelRepository.save(carModel);
    }


    public void setCarRating(CarModel carModel, CarRatingRequest request) {
        CarRating carRating = new CarRating.CarRatingBuilder(carModel, request).build();
        carRatingRepository.save(carRating);
    }


    public void setCarTrim(CarRating carRating, CarTrimRequest request) {
        CarTrim carTrim = new CarTrim.CarTrimBuilder(carRating, request).build();
        carTrimRepository.save(carTrim);
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


    public void putManufacturer(long manufacturerId, ManufacturerRequest request) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId).orElseThrow(CMissingDataException::new);
        manufacturer.putManufacturer(request);
        manufacturerRepository.save(manufacturer);
    }

    public void putCarModel(long carModelId, Manufacturer manufacturer, CarModelRequest request) {
        CarModel carModel = carModelRepository.findById(carModelId).orElseThrow(CMissingDataException::new);
        carModel.putCarModel(manufacturer, request);
        carModelRepository.save(carModel);
    }


}
