package com.dailyquest.notification.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "tb_notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noti_no")
    private Long notiNo;

//    @ManyToOne
//    @JoinColumn(name = "studentNo", nullable = false)
//    private long student;
    @Column(name = "student_no")
    private long studentNo;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "send_time")
    private LocalDateTime sendTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "noti_type", nullable = false)
    private NotiType notiType;
}
