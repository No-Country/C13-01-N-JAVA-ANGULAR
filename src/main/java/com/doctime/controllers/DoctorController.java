package com.doctime.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctime.model.doctor.DataListDoctor;
import com.doctime.model.doctor.DataUpdateDoctor;
import com.doctime.model.doctor.DoctorEntity;
import com.doctime.model.schedule.DataCreateSchedule;
import com.doctime.repository.DoctorRepository;
import com.doctime.repository.ScheduleRepository;
import com.doctime.service.CustomUserService;
import com.doctime.service.DoctorService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    CustomUserService customUserService;

    @PostMapping("/schedule")
    @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<DataCreateSchedule> addSchedule(@Valid @RequestBody DataCreateSchedule dataCreateSchedule) {
        Long id = customUserService.getCurrentCustomUser().getId_user();
        DoctorEntity doctor = doctorRepository.findByUserId(id);
        return ResponseEntity.ok(doctorService.saveSchedule(doctor, dataCreateSchedule));
    }

    @GetMapping("/schedule/listar")
    @PreAuthorize("hasRole('DOCTOR')")
    @Transactional
    public ResponseEntity<List<DataCreateSchedule>> getScheduleById() {
        System.out.println("SCHEDULEEEEEEEEEEEEEE" + scheduleRepository.findById(1L));
        return ResponseEntity.ok(scheduleRepository.findAll().stream().map(DataCreateSchedule::new).toList());
    }

    @GetMapping
    public ResponseEntity<List<DataListDoctor>> listDoctos() {
        return ResponseEntity.ok(doctorRepository.findAll().stream().map(DataListDoctor::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataListDoctor> getDoctorById(@PathVariable(name = "id") Long id) {
        DoctorEntity doctor = doctorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataListDoctor(doctor));
    }

    @PatchMapping
    @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<DataListDoctor> updateDoctor(@Valid @RequestBody DataUpdateDoctor dataUpdateDoctor) {
        Long id = customUserService.getCurrentCustomUser().getId_user();
        DoctorEntity doctor = doctorRepository.findByUserId(id);

        DataListDoctor dataListDoctor = doctorService.updateDoctorUser(doctor, dataUpdateDoctor);
        return ResponseEntity.ok(dataListDoctor);
    }
}