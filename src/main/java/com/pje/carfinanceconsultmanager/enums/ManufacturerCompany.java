package com.pje.carfinanceconsultmanager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ManufacturerCompany {
    HYUNDAI("현대"),
    KIA("기아"),
    AUDI("아우디")

    ;

    private final String name;
}
