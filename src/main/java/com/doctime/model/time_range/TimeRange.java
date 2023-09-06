// package com.doctime.model.time_range;

// import java.time.LocalDateTime;

// import org.apache.tomcat.jni.Library;

// import com.doctime.model.schedule.ScheduleEntity;

// import jakarta.persistence.*;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Entity
// @Table(name = "tb_time_range")
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class TimeRange {

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private long id;

// @Column
// private LocalDateTime start_time;

// @Column
// private LocalDateTime end_time;

// @ManyToOne
// @JoinColumn(name = "id_schedule")
// private ScheduleEntity scheduleEntity;
// }
