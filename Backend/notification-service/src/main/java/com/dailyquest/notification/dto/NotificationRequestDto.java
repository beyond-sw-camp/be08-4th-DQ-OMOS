package com.dailyquest.notification.dto;

import com.dailyquest.notification.entity.NotiType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequestDto {
    private long studentNo;
    private String message;
    private NotiType notiType;
}
