package com.pje.carfinanceconsultmanager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DriveMethod {
    FF("전륜"),
    FR("후륜"),
    AWD("4륜")

    ;
    private final String name;
}
