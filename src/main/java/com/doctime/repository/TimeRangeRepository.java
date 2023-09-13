package com.doctime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctime.model.timeRange.TimeRange;

public interface TimeRangeRepository extends JpaRepository<TimeRange, Long> {

}
