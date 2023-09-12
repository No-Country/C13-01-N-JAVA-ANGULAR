package com.doctime.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctime.model.schedule.DataCreateSchedule;
import com.doctime.model.schedule.ScheduleEntity;
import com.doctime.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping
    @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<ScheduleEntity> addSchedule(@RequestBody DataCreateSchedule dataCreateSchedule) {
        System.out.println(dataCreateSchedule);
        return ResponseEntity.ok(doctorService.addSchedule(dataCreateSchedule));
    }
}