package com.doctime.model.schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import com.doctime.model.doctor.DoctorEntity;
import com.doctime.model.timeRange.TimeRange;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_schedule")
public class ScheduleEntity {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(updatable = false)
    private LocalDate dayOfWeek;

    @JsonIgnore
    @Column(updatable = false)
    private LocalDateTime created_at;

    @JsonIgnore
    @Column
    private LocalDateTime update_at;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private DoctorEntity doctor;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<TimeRange> timeRange;

}
