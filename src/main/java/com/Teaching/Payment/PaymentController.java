package com.Teaching.Payment;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import com.razorpay.*;

@Controller
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/")
    public String paymentGatewayPro() {
        return "AbhijeetPayment";
    }

    @PostMapping("/create_order")
    @ResponseBody
    public String createOrder(@RequestBody Map<String,Object> data) throws RazorpayException {
        System.out.println("\n"+data+"\n");

        int amount = Integer.parseInt(data.get("amount").toString());
        RazorpayClient razorpayClient = new RazorpayClient("rzp_test_GHH9Q147mq0G9x","w4o6Z4XdlTe2VNaTWTlctiim");
        //Create JSON Object
        JSONObject ob = new JSONObject();
        ob.put("amount",amount*100);
        ob.put("currency","INR");
        ob.put("receipt","txn_1234");
        //Create Order
        Order order = razorpayClient.orders.create(ob);
        System.out.println("\n\n"+order+"\n\n");

        String id = order.get("id").toString();
        int rupees = Integer.parseInt(order.get("amount").toString())/100;
        String status = order.get("status").toString();

        System.out.println("id:"+id+"\nrupees:"+rupees+"\nstatus:"+status);

//        Pay pay = new Pay();
//        pay.setId(id);
//        pay.setAmount(""+rupees);
//        pay.setStatus(status);
//        paymentRepository.save(pay);

        return order.toString();
    }

    @GetMapping("/updatePayment")
    @ResponseBody
    public String getPaymentDetails(@RequestBody Map<String,Object> data) throws RazorpayException {
        RazorpayClient razorpayClient = new RazorpayClient("rzp_test_GHH9Q147mq0G9x","w4o6Z4XdlTe2VNaTWTlctiim");
        String paymentId = data.get("payment_id").toString();
        Payment fetch = razorpayClient.payments.fetch(paymentId);
        return fetch.toString();
    }
}