package com.delivery.db.store.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StoreCategory {
    KOREAN_FOOE("한식", "한식"),

    CHINESE_FOOE("중식", "중식"),

    JAPANESE_FOOD("일실", "일싱"),

    CHICKEN("치킨", "치킨"),

    PIZZA("피자", "피자"),

    HAMBURGER("햄버거", "햄버거"),

    COFFEE_TEA("커피&티", "커피&티");
    ;

    private String display;
    private String description;
}
