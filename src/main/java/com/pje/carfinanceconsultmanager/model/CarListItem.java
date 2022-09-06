package com.pje.carfinanceconsultmanager.model;

import com.pje.carfinanceconsultmanager.entity.CarModel;
import com.pje.carfinanceconsultmanager.interfaces.CommonModelBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarListItem {
    private String carReleaseStatusName;
    private String carFullName;

    private CarListItem(CarListItemBuilder builder) {
        this.carReleaseStatusName = builder.carReleaseStatusName;
        this.carFullName = builder.carFullName;
    }

    public static class CarListItemBuilder implements CommonModelBuilder<CarListItem> {
        private final String carReleaseStatusName;
        private final String carFullName;

        public CarListItemBuilder(CarModel carModel) {
            this.carReleaseStatusName = carModel.getCarReleaseStatus().getName();
            this.carFullName = carModel.getManufacturer().getManufacturerCompany().getName() + " " + carModel.getModelName();
        }


        @Override
        public CarListItem build() {
            return new CarListItem(this);
        }
    }
}
