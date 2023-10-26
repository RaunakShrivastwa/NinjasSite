package com.Teaching.Payment;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.Teaching.Notification.Notification;
import com.Teaching.Notification.NotificationRepository;
import com.razorpay.*;

@CrossOrigin(origins = "*")
@Controller
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping("/")
    public String paymentGatewayPro() {
        return "AbhijeetPayment";
    }

    @PostMapping("/create_order")
    @ResponseBody
    public String createOrder(@RequestBody Map<String, Object> data) throws RazorpayException {
        int amount = Integer.parseInt(data.get("amount").toString());
        RazorpayClient razorpayClient = new RazorpayClient("rzp_test_GHH9Q147mq0G9x", "w4o6Z4XdlTe2VNaTWTlctiim");

        JSONObject ob = new JSONObject();
        ob.put("amount", amount * 100);
        ob.put("currency", "INR");
        ob.put("receipt", "txn_1234");

        Order order = razorpayClient.orders.create(ob);
        return order.toString();
    }

    @PostMapping("/savePayment")
    @ResponseBody
    public String getPaymentDetails(@RequestBody Map<String, Object> data) throws RazorpayException, ParseException {
        RazorpayClient razorpayClient = new RazorpayClient("rzp_test_GHH9Q147mq0G9x", "w4o6Z4XdlTe2VNaTWTlctiim");
        String paymentId = data.get("payment_id").toString();
        Payment fetch = razorpayClient.payments.fetch(paymentId);

        Pay pay = new Pay();
        pay.setId(paymentId);
        pay.setAmount("" + Integer.parseInt(fetch.get("amount").toString()) / 100);
        pay.setStatus(fetch.get("status"));
        pay.setNumber(fetch.get("contact"));

        String date = LocalDate.now().toString();
        String day = new SimpleDateFormat("dd").format(new SimpleDateFormat("yyyy-MM-dd").parse("" + date));
        String month = new SimpleDateFormat("MM").format(new SimpleDateFormat("yyyy-MM-dd").parse("" + date));
        String year = new SimpleDateFormat("yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse("" + date));

        pay.setDay(day);
        pay.setMonth(month);
        pay.setYear(year);

        paymentRepository.save(pay);

        // Notification create and saved .....
        Notification notification = new Notification();
        notification.setId(UUID.randomUUID().toString());
        notification.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        notification.setMessage("the payment for java course and the amount is " + pay.getAmount());
        notificationRepository.save(notification);

        return pay.toString();
    }

}
