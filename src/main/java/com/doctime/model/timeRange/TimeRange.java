package com.doctime.model.timeRange;

import java.time.LocalTime;

import com.doctime.model.schedule.ScheduleEntity;
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
@Table(name = "tb_time_range")
public class TimeRange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalTime start_time;

    @Column
    private LocalTime end_time;

    @ManyToOne
    @JoinColumn(name = "id_schedule")
    private ScheduleEntity schedule;
}
