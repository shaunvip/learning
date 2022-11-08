package com.example.ola_uber_lld.model.enums;

public enum BookingStatusEnum {
    BOOKING,SEARCHING_DRIVER,RIDING,CANCEL,COMPLETED;
    private String value;

    @Override
    public String toString() {
        return "BookingStatusEnum{" +
                "value='" + value + '\'' +
                '}';
    }
}
