package com.Teaching.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class NotificationController {
    @Autowired
    private NotificationRepository repository;

    @GetMapping("/getNotification")
    public List<Notification> getNotification() {
        List<Notification> allInfo = repository.findAll();
        for (Notification notification:allInfo) {
            String msgDate = notification.getDate();
            String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            String timeDifference = CalculateTime.findDifference(msgDate, currentDate);
            notification.setDate(timeDifference);
        }
        return allInfo;
    }
}
