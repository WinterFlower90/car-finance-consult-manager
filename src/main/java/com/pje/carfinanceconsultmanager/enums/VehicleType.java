package com.pje.carfinanceconsultmanager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VehicleType {
    SMALL_SUV("SUV(소형)"),
    MIDSIZE_SUV("SUV(중형)"),
    LARGE_SUV("SUV(대형)"),
    SMALL_SEDAN("세단(소형)"),
    SUBCOMPACT_SEDAN("세단(준중형)"),
    MIDSIZE_SEDAN("세단(중형)"),
    LARGE_SEDAN("세단(대형)")

    ;

    private final String name;
}
