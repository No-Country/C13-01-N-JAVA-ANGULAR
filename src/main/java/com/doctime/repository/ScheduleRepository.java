package com.doctime.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctime.model.doctor.DoctorEntity;
import com.doctime.model.schedule.ScheduleEntity;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
    Optional<ScheduleEntity> findByDoctorAndDayOfWeek(DoctorEntity doctorEntity, LocalDate datOfWeek);
}
