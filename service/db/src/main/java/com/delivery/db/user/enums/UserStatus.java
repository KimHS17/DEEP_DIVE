package com.delivery.db.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserStatus {
    REGISTERED("등록"),
    UNREGISDETERED("해지"),
    ;

    private final String description;

}
