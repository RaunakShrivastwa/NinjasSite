package com.Teaching.InfoPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Teaching.Payment.Pay;
import com.Teaching.Payment.PaymentRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
public class PaymentFetch {
    @Autowired
    public PaymentRepository paymentRepository;

    //Get payment information of a year separate month value
    @GetMapping("/getPay")
    public List<InfoPayment> getPayment() throws ParseException {
        List<Pay> allPayment = paymentRepository.findAll();
        HashMap<String,Integer> map = new HashMap<>();
        SimpleDateFormat month_date = new SimpleDateFormat("MMM");
        for (Pay pay:allPayment) {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(pay.getYear()+"-"+pay.getMonth()+"-"+pay.getDay());
            String month_name = month_date.format(date);
            int sum = Integer.parseInt(pay.getAmount());
            map.put(month_name, map.getOrDefault(month_name,0) + sum);
        }

        LocalDate date = LocalDate.now();
        int currentMonth = Integer.parseInt(new SimpleDateFormat("MM").format(new SimpleDateFormat("yyyy-MM-dd").parse(""+date)));

        List<InfoPayment> monthPay = new ArrayList<>();
        for(int i=1;i<=currentMonth;i++) {
            String month = month_date.format(new SimpleDateFormat("MM").parse(""+i));
            if(map.containsKey(month)){
                int amount = map.get(month);
                InfoPayment payment = new InfoPayment();
                payment.setAmount((long) amount);
                payment.setKey(month);
                monthPay.add(payment);
            }else {
                InfoPayment payment = new InfoPayment();
                payment.setAmount(0L);
                payment.setKey(month);
                monthPay.add(payment);
            }
        }
        return monthPay;
    }

    //Calculate a all month payment
    @GetMapping("/getMonthlyPay")
    public InfoPayment getMonthlyPayment() throws ParseException {
        String date = LocalDate.now().toString();
        String month = new SimpleDateFormat("MM").format(new SimpleDateFormat("yyyy-MM-dd").parse(""+date));
        String year = new SimpleDateFormat("yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(""+date));

        String month_Name = new SimpleDateFormat("MMM").format(new SimpleDateFormat("yyyy-MM-dd").parse(""+date));

        List<Pay> monthPayment = paymentRepository.findByMonthAndYear(month,year);
        Long payment = 0L;
        for(Pay pay:monthPayment) {
            payment += Integer.parseInt(pay.getAmount());
        }
        InfoPayment monthlyPayment = new InfoPayment(month_Name+"-"+year,payment);
        return monthlyPayment;
    }

    //Calculate a all year payment
    @GetMapping("/getYearlyPay")
    public InfoPayment getYearPayment() throws ParseException {
        String date = LocalDate.now().toString();
        String year = new SimpleDateFormat("yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(""+date));

        List<Pay> monthPayment = paymentRepository.findByYear(year);
        Long payment = 0L;
        for(Pay pay:monthPayment) {
            payment += Integer.parseInt(pay.getAmount());
        }
        InfoPayment monthlyPayment = new InfoPayment(year,payment);
        return monthlyPayment;
    }

    //Collect all type of income information
    @GetMapping("/getIncome")
    public List<InfoPayment> getIncome() throws ParseException {
        List<Pay> allPayment = paymentRepository.findAll();
        HashMap<String,Integer> map = new HashMap<>();
        SimpleDateFormat month_date = new SimpleDateFormat("MMM");
        for (Pay pay:allPayment) {
            int sum = Integer.parseInt(pay.getAmount());
            map.put(pay.getMedium(), map.getOrDefault(pay.getMedium(),0) + sum);
        }

        List<InfoPayment> monthPay = new ArrayList<>();
        Set<String> keys = map.keySet();
        for(String key:keys) {
            InfoPayment payment = new InfoPayment(key,(long)Integer.parseInt(String.valueOf(map.get(key))));
            monthPay.add(payment);
        }
        return monthPay;
    }
}

