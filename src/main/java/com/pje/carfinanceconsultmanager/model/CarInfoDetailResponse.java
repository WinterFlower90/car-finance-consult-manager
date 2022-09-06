package com.pje.carfinanceconsultmanager.model;

import com.pje.carfinanceconsultmanager.entity.CarModel;
import com.pje.carfinanceconsultmanager.interfaces.CommonModelBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarInfoDetailResponse {
    private String makerLogoUrl;

    private String carReleaseStatusName;

    private CarInfoDetailRangeItem priceItem;

    private String vehicleTypeName;

    private List<String> carFuelTypes; //배열

    private CarInfoDetailRangeItem displacementItem;

    private CarInfoDetailRangeItem fuelEfficiencyItem;

    private CarInfoDetailRangeItem personnelCountItem;

    private CarInfoDetailResponse(CarInfoDetailResponseBuilder builder) {
        this.makerLogoUrl = builder.makerLogoUrl;
        this.carReleaseStatusName = builder.carReleaseStatusName;
        this.priceItem = builder.priceItem;
        this.vehicleTypeName = builder.vehicleTypeName;
        this.carFuelTypes = builder.carFuelTypes;
        this.displacementItem = builder.displacementItem;
        this.fuelEfficiencyItem = builder.fuelEfficiencyItem;
        this.personnelCountItem = builder.personnelCountItem;
    }

    public static class CarInfoDetailResponseBuilder implements CommonModelBuilder<CarInfoDetailResponse> {
        private final String makerLogoUrl;
        private final String carReleaseStatusName;
        private final CarInfoDetailRangeItem priceItem;
        private final String vehicleTypeName;
        private final List<String> carFuelTypes; //배열
        private final CarInfoDetailRangeItem displacementItem;
        private final CarInfoDetailRangeItem fuelEfficiencyItem;
        private final CarInfoDetailRangeItem personnelCountItem;

        public CarInfoDetailResponseBuilder(
                CarModel carModel,
                Double minPrice,
                Double maxPrice,
                List<String> carFuelTypes,
                Integer minDisplacement,
                Integer maxDisplacement,
                Double minFuelEfficiency,
                Double maxFuelEfficiency,
                Integer minPersonnelCount,
                Integer maxPersonnelCount
        ) {
            this.makerLogoUrl = carModel.getManufacturer().getManufacturerLogoUri();
            this.carReleaseStatusName = carModel.getCarReleaseStatus().getName();

            CarInfoDetailRangeItem priceItem = new CarInfoDetailRangeItem();
            priceItem.setMinDoubleValue(minPrice);
            priceItem.setMaxDoubleValue(maxPrice);
            this.priceItem = priceItem;

            this.vehicleTypeName = carModel.getVehicleType().getName();

            this.carFuelTypes = carFuelTypes;

            CarInfoDetailRangeItem displacementItem = new CarInfoDetailRangeItem();
            displacementItem.setMinIntValue(minDisplacement);
            displacementItem.setMaxIntValue(maxDisplacement);
            this.displacementItem = displacementItem;

            CarInfoDetailRangeItem fuelEfficiencyItem = new CarInfoDetailRangeItem();
            fuelEfficiencyItem.setMinDoubleValue(minFuelEfficiency);
            fuelEfficiencyItem.setMaxDoubleValue(maxFuelEfficiency);
            this.fuelEfficiencyItem = fuelEfficiencyItem;

            CarInfoDetailRangeItem personnelCountItem = new CarInfoDetailRangeItem();
            personnelCountItem.setMinIntValue(minPersonnelCount);
            personnelCountItem.setMaxIntValue(maxPersonnelCount);
            this.personnelCountItem = personnelCountItem;

        }


        @Override
        public CarInfoDetailResponse build() {
            return new CarInfoDetailResponse(this);
        }
    }
}
