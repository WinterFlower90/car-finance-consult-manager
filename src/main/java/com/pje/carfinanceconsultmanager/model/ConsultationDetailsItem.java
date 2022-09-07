package com.pje.carfinanceconsultmanager.model;

import com.pje.carfinanceconsultmanager.entity.ConsultationDetails;
import com.pje.carfinanceconsultmanager.interfaces.CommonModelBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConsultationDetailsItem {
    private Long consultationDetailsId;

    private String memberName;

    private String memberPhone;

    private LocalDateTime dateConsult;

    private String carFullInfo; // manufacturerName, carModel-name, vehicleType name;

    private Long manufacturerId;

    private Long carModelId;

    private Long carRatingId;

    private Long carTrimId;

    private ConsultationDetailsItem(ConsultationDetailsItemBuilder builder) {
        this.consultationDetailsId = builder.consultationDetailsId;
        this.memberName = builder.memberName;
        this.memberPhone = builder.memberPhone;
        this.dateConsult = builder.dateConsult;
        this.carFullInfo = builder.carFullInfo;
        this.manufacturerId = builder.manufacturerId;
        this.carModelId = builder.carModelId;
        this.carRatingId = builder.carRatingId;
        this.carTrimId = builder.carTrimId;
    }

    public static class ConsultationDetailsItemBuilder implements CommonModelBuilder<ConsultationDetailsItem> {
        private final Long consultationDetailsId;
        private final String memberName;
        private final String memberPhone;
        private final LocalDateTime dateConsult;
        private final String carFullInfo; // manufacturerName, carModel-name, vehicleType name;
        private final Long manufacturerId;
        private final Long carModelId;
        private final Long carRatingId;
        private final Long carTrimId;

        public ConsultationDetailsItemBuilder(ConsultationDetails details) {
            this.consultationDetailsId = details.getId();
            this.memberName = details.getMemberName();
            this.memberPhone = details.getMemberPhone();
            this.dateConsult = details.getDateConsult();
            this.carFullInfo = "[" + details.getCarTrim().getCarRating().getCarModel().getManufacturer().getManufacturerCompany().getName() + "] "
                    + details.getCarTrim().getCarRating().getCarModel().getModelName() +
                    " 차량 타입은 " + details.getCarTrim().getCarRating().getCarModel().getVehicleType().getName() + " 입니다.";
            this.manufacturerId = details.getCarTrim().getCarRating().getCarModel().getManufacturer().getId();
            this.carModelId = details.getCarTrim().getCarRating().getCarModel().getId();
            this.carRatingId = details.getCarTrim().getCarRating().getId();
            this.carTrimId = details.getCarTrim().getId();
        }

        @Override
        public ConsultationDetailsItem build() {
            return new ConsultationDetailsItem(this);
        }
    }

}
