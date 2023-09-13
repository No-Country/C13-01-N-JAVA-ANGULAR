package com.doctime.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

    // public ScheduleEntity saveSchedule(Long id_doctor, DataCreateSchedule
    // dataCreateSchedule) {
    // // Obtener el doctor por ID (asegurándose de que el doctor exista)
    // DoctorEntity doctor = doctorRepository.findById(id_doctor)
    // .orElseThrow(() -> new NullPointerException("Doctor no encontrado"));

    // // Verificar si el día laborable ya existe por su fecha
    // ScheduleEntity scheduleExist = scheduleRepository
    // .findByDoctorAndDayOfWeek(doctor, dataCreateSchedule.dayOfWeek())
    // .orElse(null);

    // if (scheduleExist == null) {
    // // Crear un nuevo día laborable si no existe
    // ScheduleEntity schedule = ScheduleEntity.builder()
    // .dayOfWeek(dataCreateSchedule.dayOfWeek())
    // .created_at(LocalDateTime.now())
    // .update_at(LocalDateTime.now())
    // .doctor(doctor).build();
    // // Guardar el día laborable en la base de datos
    // schedule = scheduleRepository.save(schedule);

    // // Crear y asociar los rangos de horas al día laborable
    // for (DataCreateTimeRange rangoHorasDTO : dataCreateSchedule.timeRange()) {
    // TimeRange rangoHoras = TimeRange.builder()
    // .start_time(rangoHorasDTO.startTime())
    // .end_time(rangoHorasDTO.endTime())
    // .schedule(schedule).build();

    // // Guardar el rango de horas en la base de datos
    // timeRangeRepository.save(rangoHoras);
    // }

    // // Devolver el día laborable creado
    // return schedule;
    // } else {
    // // Actualizar los rangos de horas existentes (eliminar y crear de nuevo)
    // Set<TimeRange> rangosHorasExistentes = scheduleExist.getTimeRange();
    // rangosHorasExistentes.clear(); // Eliminar los rangos existentes

    // for (DataCreateTimeRange rangoHorasDTO : dataCreateSchedule.timeRange()) {
    // TimeRange rangoHoras = TimeRange.builder()
    // .start_time(rangoHorasDTO.startTime())
    // .end_time(rangoHorasDTO.endTime())
    // .schedule(scheduleExist).build();

    // // Guardar el rango de horas en la base de datos
    // timeRangeRepository.save(rangoHoras);
    // }

    // // Guardar el día laborable actualizado en la base de datos
    // scheduleRepository.save(scheduleExist);

    // // Devolver el día laborable actualizado
    // return scheduleExist;
    // }
    // }
}