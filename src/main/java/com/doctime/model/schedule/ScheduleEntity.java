package com.doctime.model.schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import com.doctime.model.doctor.DoctorEntity;
import com.doctime.model.timeRange.TimeRange;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(updatable = false)
    private LocalDate dayOfWeek;
    @Column(updatable = false)
    private LocalDateTime created_at;
    @Column
    private LocalDateTime update_at;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private DoctorEntity doctor;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<TimeRange> timeRanges;

}
