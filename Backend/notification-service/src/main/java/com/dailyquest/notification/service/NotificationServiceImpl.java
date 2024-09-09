package com.dailyquest.notification.service;

import com.dailyquest.notification.dto.NotificationRequestDto;
import com.dailyquest.notification.dto.NotificationResponseDto;
import com.dailyquest.notification.entity.NotiType;
import com.dailyquest.notification.entity.Notification;
import com.dailyquest.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationResponseDto saveNotification(NotificationRequestDto requestDto) {
        Notification notification = new Notification();
        notification.setStudentNo(requestDto.getStudentNo());
        notification.setMessage(requestDto.getMessage());
        notification.setSendTime(LocalDateTime.now());
        notification.setNotiType(requestDto.getNotiType());

        Notification savedNotification = notificationRepository.save(notification);

        return new NotificationResponseDto(
                savedNotification.getNotiNo(),
                savedNotification.getStudentNo(),
                savedNotification.getMessage(),
                savedNotification.getSendTime(),
                savedNotification.getNotiType()
        );
    }

    @Override
    public List<NotificationResponseDto> getAllNotifications() {
        return notificationRepository.findAll().stream()
                .map(notification -> new NotificationResponseDto(
                        notification.getNotiNo(),
                        notification.getStudentNo(),
                        notification.getMessage(),
                        notification.getSendTime(),
                        notification.getNotiType()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<NotificationResponseDto> getNotificationsByNotiType(NotiType notiType) {
        return notificationRepository.findByNotiType(notiType).stream()
                .map(notification -> new NotificationResponseDto(
                        notification.getNotiNo(),
                        notification.getStudentNo(),
                        notification.getMessage(),
                        notification.getSendTime(),
                        notification.getNotiType()
                ))
                .collect(Collectors.toList());
    }
}