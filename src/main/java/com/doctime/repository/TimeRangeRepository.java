package com.doctime.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctime.model.schedule.ScheduleEntity;
import com.doctime.model.timeRange.TimeRange;

public interface TimeRangeRepository extends JpaRepository<TimeRange, Long> {
    Set<TimeRange> findByScheduleId(Long id);

    void deleteBySchedule(ScheduleEntity scheduleEntity);
}
