package com.pje.carfinanceconsultmanager.entity;

import com.pje.carfinanceconsultmanager.interfaces.CommonModelBuilder;
import com.pje.carfinanceconsultmanager.model.CarRatingRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carModelId", nullable = false)
    private CarModel carModel;

    @Column(nullable = false)
    private Double ratingValue; //차량 등급 ex) 2.5 / 2.0 / 3.5 ...

    @Column(nullable = false, length = 10)
    private String engineType; //엔진 타입 ex) V6 / 직렬4기통 ...

    @Column(nullable = false)
    private Double maximumTorque; //최대 토크 ex) 191.0Nm / 322.0Nm ...

    @Column(nullable = false)
    private Double highestOutput; //최고 출력 ex) 146ps ...

    @Column(nullable = false)
    private LocalDateTime dateCreate;

    @Column(nullable = false)
    private LocalDateTime dateUpdate;

    private CarRating(CarRatingBuilder builder) {
        this.carModel = builder.carModel;
        this.ratingValue = builder.ratingValue;
        this.engineType = builder.engineType;
        this.maximumTorque = builder.maximumTorque;
        this.highestOutput = builder.highestOutput;
        this.dateCreate = builder.dateCreate;
        this.dateUpdate = builder.dateUpdate;
    }

    public static class CarRatingBuilder implements CommonModelBuilder<CarRating> {
        private final CarModel carModel;
        private final Double ratingValue; //차량 등급 ex) 2.5 / 2.0 / 3.5 ...
        private final String engineType; //엔진 타입 ex) V6 / 직렬4기통 ...
        private final Double maximumTorque; //최대 토크 ex) 191.0Nm / 322.0Nm ...
        private final Double highestOutput; //최고 출력 ex) 146ps ...
        private final LocalDateTime dateCreate;
        private final LocalDateTime dateUpdate;

        public CarRatingBuilder(CarModel carModel, CarRatingRequest request) {
            this.carModel = carModel;
            this.ratingValue = request.getRatingValue();
            this.engineType = request.getEngineType();
            this.maximumTorque = request.getMaximumTorque();
            this.highestOutput = request.getHighestOutput();
            this.dateCreate = LocalDateTime.now();
            this.dateUpdate = LocalDateTime.now();
        }

        @Override
        public CarRating build() {
            return new CarRating(this);
        }
    }
}
