package com.Teaching.Notification;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notification {
    @Id
    private String id;
    private String message;
    private String date;
}