package com.Teaching.Chapter;

import com.Teaching.Chapter.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepositery extends JpaRepository<Chapter,Long> {
    List<Chapter> findByCourseName(String course);

    Chapter findByContentType(String content);
     
}
