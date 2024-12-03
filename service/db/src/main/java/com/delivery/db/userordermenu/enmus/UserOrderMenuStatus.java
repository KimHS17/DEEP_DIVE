package com.delivery.db.userordermenu.enmus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserOrderMenuStatus {
    REGISTERED("등록"),

    UNREGISTERED("해지"),

    ;

    private String description;
}
