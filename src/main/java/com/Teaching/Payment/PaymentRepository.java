package com.Teaching.Payment;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface PaymentRepository extends JpaRepository<Pay,String> {
    List<Pay> findByMonthAndYear(String month,String year);
    List<Pay> findByYear(String Year);

}