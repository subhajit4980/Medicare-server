package com.subhajit.Medicare.Controllers.API.Order;

import com.razorpay.Payment;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.subhajit.Medicare.Models.Order;
import com.subhajit.Medicare.Models.User;
import com.subhajit.Medicare.Payload.response.PaymentLinkResponse;
import com.subhajit.Medicare.Payload.response.UpdatePaymentResponse;
import com.subhajit.Medicare.Repository.CartRepository;
import com.subhajit.Medicare.Repository.OrderRepository;
import com.subhajit.Medicare.Repository.ProductRepository;
import com.subhajit.Medicare.Repository.UserRepository;
import jdk.jshell.spi.ExecutionControl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CartRepository cartRepository;
    @PostMapping("/{orderId}")
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(@PathVariable String orderId) throws ExecutionControl.UserException, RazorpayException {
        Order order= orderRepository.findByOrderId(orderId).orElseThrow(() -> new UsernameNotFoundException("item Not Found with"));
        User user=userRepository.findByEmail(order.getEmail()).orElseThrow(() -> new UsernameNotFoundException("user Not not found"));
        PaymentLinkResponse res=new PaymentLinkResponse();
        try {
            RazorpayClient razorpayClient =new RazorpayClient("rzp_test_HSDi72W2hAJpCS","s8c5jMntBliyvvrkKRHRvpp0");
            JSONObject paymentRequest=new JSONObject();
            paymentRequest.put("amount",order.getPrice()*100);
            paymentRequest.put("currency","INR");
//
            JSONObject customer=new JSONObject();
            customer.put("name",user.getFirstName()+" "+user.getLastName());
            customer.put("email",order.getEmail());
            customer.put("contact",order.getMobileNumber());
            paymentRequest.put("customer",customer);
//
            JSONObject notify = new JSONObject();
            notify.put("sms",true);
            notify.put("email",true);
            paymentRequest.put("notify",notify);
//
//            paymentRequest.put("callback_url","payment success link");
            paymentRequest.put("callback_method","get");
            PaymentLink paymentLink=razorpayClient.paymentLink.create(paymentRequest);
            String paymentLinkId =paymentLink.get("id");
            String paymentUrl =paymentLink.get("short_url");
            res.setPayment_link_Id(paymentLinkId);
            res.setPayment_link_url(paymentUrl);
            return new ResponseEntity<PaymentLinkResponse>(res, HttpStatus.CREATED);
        }catch (Exception e){
            throw new RazorpayException(e.getMessage());
        }
    }
    @PostMapping("/updatePayment")
    public ResponseEntity<UpdatePaymentResponse> updatePayment(
            @RequestParam(name = "payment_id")String paymentId,
            @RequestParam(name="order_id") String orderId
    ) throws  RazorpayException{
        RazorpayClient razorpayClient =new RazorpayClient("rzp_test_HSDi72W2hAJpCS","s8c5jMntBliyvvrkKRHRvpp0");
        Order order= orderRepository.findByOrderId(orderId).orElseThrow(() -> new UsernameNotFoundException("item Not Found with"));
        try {
            Payment payment= razorpayClient.payments.fetch(paymentId);
            if(payment.get("status").equals("captured")) {
                order.setStatus("PLACED");
                order.setPaymentStatus(true);
                order.setTransectionId(paymentId);
                orderRepository.save(order);
            }
            UpdatePaymentResponse response = new UpdatePaymentResponse();
            response.setMessage("Payment Done and Your Order get placed successfully");
            response.setStatus(true);
            return  new ResponseEntity<UpdatePaymentResponse>(response,HttpStatus.OK);
        }catch (Exception e) {
            throw new RazorpayException(e.getMessage());
        }
    }
}
