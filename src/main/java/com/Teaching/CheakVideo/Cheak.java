package com.Teaching.CheakVideo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cheak {
    @Id
    private String id;
    private String studentId;
    private String videoId;
    private String flag;
}
