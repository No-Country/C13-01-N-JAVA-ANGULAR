package com.doctime.model.schedule;

import java.time.LocalDate;
import java.util.Set;

import com.doctime.model.timeRange.DataCreateTimeRange;

public record DataCreateSchedule(
        LocalDate dayOfWeek,
        Set<DataCreateTimeRange> timeRange) {
}