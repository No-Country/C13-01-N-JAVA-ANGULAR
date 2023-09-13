package com.doctime.model.schedule;

import java.time.LocalDate;
import java.util.Set;

import com.doctime.model.timeRange.TimeRange;
import com.fasterxml.jackson.annotation.JsonFormat;

public record DataCreateSchedule(
                long id,
                @JsonFormat(pattern = "yyyy-MM-dd") LocalDate dayOfWeek,
                Set<TimeRange> timeRange) {

        public DataCreateSchedule(ScheduleEntity scheduleEntity) {
                this(scheduleEntity.getId(),
                                scheduleEntity.getDayOfWeek(),
                                scheduleEntity.getTimeRange());
        }

}