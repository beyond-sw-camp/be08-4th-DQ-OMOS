package com.dailyquest.notification.controller;

import com.dailyquest.notification.dto.NotificationRequestDto;
import com.dailyquest.notification.dto.NotificationResponseDto;
import com.dailyquest.notification.entity.NotiType;
import com.dailyquest.notification.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // 알림 등록
    @PostMapping
    public ResponseEntity<NotificationResponseDto> createNotification(@RequestBody NotificationRequestDto requestDto) {
        NotificationResponseDto savedNotification = notificationService.saveNotification(requestDto);
        return new ResponseEntity<>(savedNotification, HttpStatus.CREATED);
    }

    // 전체 알림 조회
    @GetMapping
    public ResponseEntity<List<NotificationResponseDto>> getAllNotifications() {
        List<NotificationResponseDto> notifications = notificationService.getAllNotifications();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    // 알림 종류별 알림 조회
    @GetMapping("/type/{notiType}")
    public ResponseEntity<List<NotificationResponseDto>> getNotificationsByType(@PathVariable String notiType) {
        NotiType type = NotiType.valueOf(notiType.toUpperCase());
        List<NotificationResponseDto> notifications = notificationService.getNotificationsByNotiType(type);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }
}
