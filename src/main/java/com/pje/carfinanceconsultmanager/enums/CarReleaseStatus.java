package com.pje.carfinanceconsultmanager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CarReleaseStatus {
    GO_ON_SALE("시판"),
    NEW("신판")
    ;

    private final String name;
}
