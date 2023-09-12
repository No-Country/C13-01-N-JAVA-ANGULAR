package com.doctime.model.timeRange;

import java.time.LocalTime;

public record DataCreateTimeRange(
        LocalTime startTime,
        LocalTime endTime) {
}
