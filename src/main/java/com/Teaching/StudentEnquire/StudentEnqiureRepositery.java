package com.Teaching.StudentEnquire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Teaching.StudentEnquire.StudentEnqiure;

@Repository
public interface StudentEnqiureRepositery extends JpaRepository<StudentEnqiure,String> {
    
}
