package com.doctime.service;

import java.time.LocalDateTime;
import java.util.Set;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctime.model.doctor.DoctorEntity;
import com.doctime.model.schedule.DataCreateSchedule;
import com.doctime.model.schedule.ScheduleEntity;
import com.doctime.model.timeRange.DataCreateTimeRange;
import com.doctime.model.timeRange.TimeRange;
import com.doctime.repository.DoctorRepository;
import com.doctime.repository.ScheduleRepository;
import com.doctime.repository.TimeRangeRepository;

@Service
public class ScheduleSerive {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private TimeRangeRepository timeRangeRepository;

    public ScheduleEntity saveSchedule(Long id_doctor, DataCreateSchedule dataCreateSchedule) {
        DoctorEntity doctor = doctorRepository.findById(id_doctor)
                .orElseThrow(() -> new NullPointerException());
        ScheduleEntity schedule = scheduleRepository
                .findByDoctorAndDayOfWeek(doctor, dataCreateSchedule.dayOfWeek()).orElse(null);
        if (schedule == null) {
            ScheduleEntity scheduleNew = ScheduleEntity.builder()
                    .dayOfWeek(dataCreateSchedule.dayOfWeek())
                    .created_at(LocalDateTime.now())
                    .update_at(LocalDateTime.now())
                    .doctor(doctor).build();
            scheduleNew = scheduleRepository.save(scheduleNew);
            for (DataCreateTimeRange dataTimeRange : dataCreateSchedule.timeRange()) {
                TimeRange timeRange = TimeRange.builder()
                        .start_time(dataTimeRange.startTime())
                        .end_time(dataTimeRange.endTime())
                        .schedule(scheduleNew).build();
                timeRangeRepository.save(timeRange);
            }
            return scheduleNew;
        } else {
            Set<TimeRange> timeRangeExistente = schedule.getTimeRanges();
            timeRangeExistente.clear();
            for (DataCreateTimeRange dataTimeRange : dataCreateSchedule.timeRange()) {
                TimeRange timeRange = TimeRange.builder()
                        .start_time(dataTimeRange.startTime())
                        .end_time(dataTimeRange.endTime())
                        .schedule(schedule).build();
                timeRangeRepository.save(timeRange);
            }
            return scheduleRepository.save(schedule);
        }
    }
}
