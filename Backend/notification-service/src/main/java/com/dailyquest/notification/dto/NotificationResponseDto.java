package com.dailyquest.notification.dto;

import com.dailyquest.notification.entity.NotiType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class NotificationResponseDto {
    private Long notiNo;
    private long studentNo;
    private String message;
    private LocalDateTime sendTime;
    private NotiType notiType;
}
