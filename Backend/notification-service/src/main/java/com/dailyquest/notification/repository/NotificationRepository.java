package com.dailyquest.notification.repository;

import com.dailyquest.notification.entity.NotiType;
import com.dailyquest.notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByNotiType(NotiType notiType);
}
