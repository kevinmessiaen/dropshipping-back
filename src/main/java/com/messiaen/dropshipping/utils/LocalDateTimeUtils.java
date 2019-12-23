package com.messiaen.dropshipping.utils;

import java.time.LocalDateTime;

public class LocalDateTimeUtils {

    public static LocalDateTime getBasketValidity() {
        return LocalDateTime.now().minusHours(1);
    }

}
