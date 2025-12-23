package com.bumsoap.tracker_more.util;

import java.time.*;

public class DateTimeUtils {
    public static LocalDateTime fromString(String dateString) {
        Instant instant = Instant.parse(dateString);
        ZoneId systemDefaultZone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = instant.atZone(systemDefaultZone);
        return zonedDateTime.toLocalDateTime();
    }
}
