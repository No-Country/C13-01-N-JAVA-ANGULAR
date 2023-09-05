// package com.doctime.model.schedule;

// import java.time.LocalDateTime;
// import java.util.Set;

// import com.doctime.model.doctor.DoctorEntity;
// import com.doctime.model.role.RoleEntity;
// import com.doctime.model.time_range.TimeRange;

// import jakarta.persistence.*;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// @Entity
// @Table(name = "tb_schedule")
// public class ScheduleEntity {
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private long id;

// // @Column
// // private LocalDateTime start_time;
// // @Column
// // private LocalDateTime end_time;

// @Column(updatable = false)
// private LocalDateTime created_at;

// // @Column
// // private LocalDateTime update_at;

// @Column
// private String address;

// @ManyToOne(cascade = CascadeType.ALL, optional = false)
// @JoinColumn(name = "id_doctor")
// private DoctorEntity doctorEntity;

// @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, fetch =
// FetchType.EAGER, orphanRemoval = true)
// private Set<TimeRange> timeRanges;

// }
