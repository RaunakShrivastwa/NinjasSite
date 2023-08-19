package com.Teaching.CheakVideo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface cheakRepo extends JpaRepository<Cheak,String>{

    Cheak findByVideoIdAndStudentId(String videoId,String studentId);
    
}
