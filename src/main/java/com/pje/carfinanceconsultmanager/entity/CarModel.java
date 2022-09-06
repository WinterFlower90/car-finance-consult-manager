package com.pje.carfinanceconsultmanager.entity;

import com.pje.carfinanceconsultmanager.enums.VehicleType;
import com.pje.carfinanceconsultmanager.interfaces.CommonModelBuilder;
import com.pje.carfinanceconsultmanager.model.CarModelRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturerId", nullable = false)
    private Manufacturer manufacturer;

    @Column(nullable = false, length = 30)
    private String modelName;

    @Column(nullable = false, length = 30)
    @Enumerated(value = EnumType.STRING)
    private VehicleType vehicleType; //차량 외장 타입

    @Column(nullable = false)
    private Double capacity; //차량 정원

    @Column(nullable = false)
    private Double fullLength; //차량 전장

    @Column(nullable = false)
    private Double fullWidth; //차량 전폭

    @Column(nullable = false)
    private Double fullHeight; //차량 전고

    @Column(nullable = false)
    private Double wheelBase; //차량 축거

    @Column(nullable = false)
    private Double beforeWheelTrack; //차량 윤거(전)

    @Column(nullable = false)
    private Double afterWheelTrack; //차량 윤거(후)

    @Column(nullable = false, length = 20)
    private String frontWheelBrake; //전륜 브레이크

    @Column(nullable = false, length = 20)
    private String rearWheelBrake; //후륜 브레이크

    @Column(nullable = false, length = 20)
    private String frontWheelSuspension; //전륜 서스펜션

    @Column(nullable = false, length = 20)
    private String rearWheelSuspension; //후륜 서스펜션

    @Column(nullable = false, length = 20)
    private String powerSteeringFormat; //파워 스티어링 형식

    @Column(nullable = false)
    private LocalDateTime dateCreate;

    @Column(nullable = false)
    private LocalDateTime dateUpdate;

    private CarModel(CarModelBuilder builder) {
        this.manufacturer = builder.manufacturer;
        this.modelName = builder.modelName;
        this.vehicleType = builder.vehicleType;
        this.capacity = builder.capacity;
        this.fullLength = builder.fullLength;
        this.fullWidth = builder.fullWidth;
        this.fullHeight = builder.fullHeight;
        this.wheelBase = builder.wheelBase;
        this.beforeWheelTrack = builder.beforeWheelTrack;
        this.afterWheelTrack = builder.afterWheelTrack;
        this.frontWheelBrake = builder.frontWheelBrake;
        this.rearWheelBrake = builder.rearWheelBrake;
        this.frontWheelSuspension = builder.frontWheelSuspension;
        this.rearWheelSuspension = builder.rearWheelSuspension;
        this.powerSteeringFormat = builder.powerSteeringFormat;
        this.dateCreate = builder.dateCreate;
        this.dateUpdate = builder.dateUpdate;
    }

    public static class CarModelBuilder implements CommonModelBuilder<CarModel> {
        private final Manufacturer manufacturer;
        private final String modelName;
        private final VehicleType vehicleType; //차량 외장 타입
        private final Double capacity; //차량 정원
        private final Double fullLength; //차량 전장
        private final Double fullWidth; //차량 전폭
        private final Double fullHeight; //차량 전고
        private final Double wheelBase; //차량 축거
        private final Double beforeWheelTrack; //차량 윤거(전)
        private final Double afterWheelTrack; //차량 윤거(후)
        private final String frontWheelBrake; //전륜 브레이크
        private final String rearWheelBrake; //후륜 브레이크
        private final String frontWheelSuspension; //전륜 서스펜션
        private final String rearWheelSuspension; //후륜 서스펜션
        private final String powerSteeringFormat; //파워 스티어링 형식
        private final LocalDateTime dateCreate;
        private final LocalDateTime dateUpdate;

        public CarModelBuilder(Manufacturer manufacturer, CarModelRequest request) {
            this.manufacturer = manufacturer;
            this.modelName = request.getModelName();
            this.vehicleType = request.getVehicleType();
            this.capacity = request.getCapacity();
            this.fullLength = request.getFullLength();
            this.fullWidth = request.getFullWidth();
            this.fullHeight = request.getFullHeight();
            this.wheelBase = request.getWheelBase();
            this.beforeWheelTrack = request.getBeforeWheelTrack();
            this.afterWheelTrack = request.getAfterWheelTrack();
            this.frontWheelBrake = request.getFrontWheelBrake();
            this.rearWheelBrake = request.getRearWheelBrake();
            this.frontWheelSuspension = request.getFrontWheelSuspension();
            this.rearWheelSuspension = request.getRearWheelSuspension();
            this.powerSteeringFormat = request.getPowerSteeringFormat();
            this.dateCreate = LocalDateTime.now();
            this.dateUpdate = LocalDateTime.now();

        }

        @Override
        public CarModel build() {
            return new CarModel(this);
        }
    }
}
