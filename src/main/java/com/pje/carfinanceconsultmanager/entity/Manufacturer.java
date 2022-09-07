package com.pje.carfinanceconsultmanager.entity;

import com.pje.carfinanceconsultmanager.enums.ManufacturerCompany;
import com.pje.carfinanceconsultmanager.interfaces.CommonModelBuilder;
import com.pje.carfinanceconsultmanager.model.ManufacturerRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ManufacturerCompany manufacturerCompany;

    @Column(nullable = true)
    private String manufacturerLogoUri;

    @Column(nullable = false)
    private LocalDateTime dateCreate;

    @Column(nullable = false)
    private LocalDateTime dateUpdate;

    public void putManufacturer(ManufacturerRequest request) {
        this.manufacturerCompany = request.getManufacturerCompany();
        this.manufacturerLogoUri = request.getManufacturerLogoUri();
        this.dateUpdate = LocalDateTime.now();
    }

    private Manufacturer(ManufacturerBuilder builder) {
        this.manufacturerCompany = builder.manufacturerCompany;
        this.dateCreate = builder.dateCreate;
        this.dateUpdate = builder.dateUpdate;
    }

    public static class ManufacturerBuilder implements CommonModelBuilder<Manufacturer> {
        private final ManufacturerCompany manufacturerCompany;
        private final LocalDateTime dateCreate;
        private final LocalDateTime dateUpdate;

        public ManufacturerBuilder(ManufacturerRequest request) {
            this.manufacturerCompany = request.getManufacturerCompany();
            this.dateCreate = LocalDateTime.now();
            this.dateUpdate = LocalDateTime.now();
        }

        @Override
        public Manufacturer build() {
            return new Manufacturer(this);
        }
    }

}
