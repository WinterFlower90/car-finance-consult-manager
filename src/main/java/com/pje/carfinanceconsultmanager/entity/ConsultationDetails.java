package com.pje.carfinanceconsultmanager.entity;

import com.pje.carfinanceconsultmanager.interfaces.CommonModelBuilder;
import com.pje.carfinanceconsultmanager.model.ConsultationDetailsRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConsultationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carTrimId", nullable = false)
    private CarTrim carTrim;

    @Column(nullable = false, length = 20)
    private String memberName;

    @Column(nullable = false, length = 15)
    private String memberPhone;

    @Column(nullable = false)
    private LocalDateTime dateConsult;

    private ConsultationDetails(ConsultationDetailsBuilder builder) {
        this.carTrim = builder.carTrim;
        this.memberName = builder.memberName;
        this.memberPhone = builder.memberPhone;
        this.dateConsult = builder.dateConsult;
    }

    public static class ConsultationDetailsBuilder implements CommonModelBuilder<ConsultationDetails> {
        private final CarTrim carTrim;
        private final String memberName;
        private final String memberPhone;
        private final LocalDateTime dateConsult;

        public ConsultationDetailsBuilder(CarTrim carTrim, ConsultationDetailsRequest request) {
            this.carTrim = carTrim;
            this.memberName = request.getMemberName();
            this.memberPhone = request.getMemberPhone();
            this.dateConsult = LocalDateTime.now();
        }

        @Override
        public ConsultationDetails build() {
            return new ConsultationDetails(this);
        }
    }
}
