package com.dailyquest.notification.service;

import com.dailyquest.notification.dto.NotificationRequestDto;
import com.dailyquest.notification.dto.NotificationResponseDto;
import com.dailyquest.notification.entity.NotiType;

import java.util.List;

public interface NotificationService {
    NotificationResponseDto saveNotification(NotificationRequestDto requestDto);
    List<NotificationResponseDto> getAllNotifications();
    List<NotificationResponseDto> getNotificationsByNotiType(NotiType notiType);
}
