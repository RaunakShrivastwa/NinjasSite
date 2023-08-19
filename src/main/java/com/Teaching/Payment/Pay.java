package com.Teaching.Payment;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pay {
    @Id
    private String id;
    private String number;
    private String amount;
    private String status;
    private String day;
    private String month;
    private String year;
    private String medium;
}
