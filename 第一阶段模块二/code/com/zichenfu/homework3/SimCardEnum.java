package com.zichenfu.homework3;

public enum SimCardEnum {
    BIGCARD("大卡"), SMALLCARD("小卡"), MICROCARD("微型卡");

    private final String cardType;

    SimCardEnum(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }
}
