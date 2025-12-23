package com.bumsoap.tracker_more.util;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class DateTimeUtils {
    public static LocalDateTime fromString(String dateString) {
        return OffsetDateTime.parse(dateString).toLocalDateTime();
    }
}
