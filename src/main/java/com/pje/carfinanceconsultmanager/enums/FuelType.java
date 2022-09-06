package com.pje.carfinanceconsultmanager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FuelType {
    LPG("LPG"),
    GASOLINE("휘발유"),
    DIESEL("경유")

    ;

    private final String name;
}
