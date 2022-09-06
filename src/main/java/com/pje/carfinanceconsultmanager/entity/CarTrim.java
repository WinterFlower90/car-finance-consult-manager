package com.pje.carfinanceconsultmanager.entity;

import com.pje.carfinanceconsultmanager.enums.DriveMethod;
import com.pje.carfinanceconsultmanager.enums.FuelType;
import com.pje.carfinanceconsultmanager.interfaces.CommonModelBuilder;
import com.pje.carfinanceconsultmanager.model.CarTrimRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarTrim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carRatingId", nullable = false)
    private CarRating carRating;

    @Column(nullable = false, length = 20)
    private String trimName; //자동차 트림명

    @Column(nullable = false, length = 10)
    @Enumerated(value = EnumType.STRING)
    private DriveMethod driveMethod; //구동 방식

    @Column(nullable = false, length = 15)
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType; // 연료 타입

    @Column(nullable = false)
    private Double engineDisplacement; //배기량 cc

    @Column(nullable = false)
    private Double carPrice; //차량 가격

    @Column(nullable = false)
    private Double toleranceWeight; //공차 중량

    @Column(nullable = false, length = 20)
    private String frontTireSpecification; //앞타이어 규격

    @Column(nullable = false, length = 20)
    private String rearTireSpecification; //뒷타이어 규격

    @Column(nullable = false)
    private Double combinedFuelEconomy; //복합연비

    @Column(nullable = false)
    private Double cityFuelEconomy; //도심연비

    @Column(nullable = false)
    private Double highwayFuelEconomy; //고속도로연비

    @Column(nullable = false)
    private Double fuelEconomyRating; //연비 등급

    @Column(nullable = false)
    private Double emissionsCo2; //Co2 배출량

    @Column(nullable = true)
    private Double zero100; //제로 백

    @Column(nullable = true)
    private Double selfDrivingLevel; //자율주행 레벨

    @Column(nullable = true)
    private Double lowPollutionGrade; //저공해등급

    @Column(nullable = false)
    private LocalDateTime dateCreate;

    @Column(nullable = false)
    private LocalDateTime dateUpdate;

    private CarTrim(CarTrimBuilder builder) {
        this.carRating = builder.carRating;
        this.trimName = builder.trimName;
        this.driveMethod = builder.driveMethod;
        this.fuelType = builder.fuelType;
        this.engineDisplacement = builder.engineDisplacement;
        this.carPrice = builder.carPrice;
        this.toleranceWeight = builder.toleranceWeight;
        this.frontTireSpecification = builder.frontTireSpecification;
        this.rearTireSpecification = builder.rearTireSpecification;
        this.combinedFuelEconomy = builder.combinedFuelEconomy;
        this.cityFuelEconomy = builder.cityFuelEconomy;
        this.highwayFuelEconomy = builder.highwayFuelEconomy;
        this.fuelEconomyRating = builder.fuelEconomyRating;
        this.emissionsCo2 = builder.emissionsCo2;
        this.dateCreate = builder.dateCreate;
        this.dateUpdate = builder.dateUpdate;
    }

    public static class CarTrimBuilder implements CommonModelBuilder<CarTrim> {
        private final CarRating carRating;
        private final String trimName;
        private final DriveMethod driveMethod;
        private final FuelType fuelType;
        private final Double engineDisplacement;
        private final Double carPrice;
        private final Double toleranceWeight;
        private final String frontTireSpecification;
        private final String rearTireSpecification;
        private final Double combinedFuelEconomy;
        private final Double cityFuelEconomy;
        private final Double highwayFuelEconomy;
        private final Double fuelEconomyRating;
        private final Double emissionsCo2;
        private final LocalDateTime dateCreate;
        private final LocalDateTime dateUpdate;

        public CarTrimBuilder(CarRating carRating, CarTrimRequest request) {
            this.carRating = carRating;
            this.trimName = request.getTrimName();
            this.driveMethod = request.getDriveMethod();
            this.fuelType = request.getFuelType();
            this.engineDisplacement = request.getEngineDisplacement();
            this.carPrice = request.getCarPrice();
            this.toleranceWeight = request.getToleranceWeight();
            this.frontTireSpecification = request.getFrontTireSpecification();
            this.rearTireSpecification = request.getRearTireSpecification();
            this.combinedFuelEconomy = request.getCombinedFuelEconomy();
            this.cityFuelEconomy = request.getCityFuelEconomy();
            this.highwayFuelEconomy = request.getHighwayFuelEconomy();
            this.fuelEconomyRating = request.getFuelEconomyRating();
            this.emissionsCo2 = request.getEmissionsCo2();
            this.dateCreate = LocalDateTime.now();
            this.dateUpdate = LocalDateTime.now();
        }

        @Override
        public CarTrim build() {
            return new CarTrim(this);
        }
    }
}
