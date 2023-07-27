package com.Teaching.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name="course_Data")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String title;
     private String deadline;

     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private String milestone;
     private String score;
     private String name;
}
