package com.gramutsav.controller;

import com.gramutsav.dto.PaymentReportDto;
import com.gramutsav.entity.PaymentDetails;
import com.gramutsav.repository.PaymentRepository;
import com.gramutsav.service.PaymentService;
import com.gramutsav.service.PhonePeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private PhonePeService phonePeService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/pay")
    public String pay(
            @RequestBody Map<String, Object> request
    ) {

        try {

            String mobileNo =
                    request.get("mobileNo").toString();

            List<Integer> sharesNo =
                    (List<Integer>) request.get("sharesNo");

            Long amount =
                    Long.parseLong(
                            request.get("amount").toString()
                    );

            return phonePeService.createPayment(
                    mobileNo,
                    sharesNo,
                    amount
            );

        } catch (Exception e) {

            e.printStackTrace();

            return "Payment Failed";
        }
    }


    @GetMapping("/status/{merchantOrderId}")
    public ResponseEntity<?> getStatus(@PathVariable String merchantOrderId){
        System.out.println("api merchantOrderId=>"+merchantOrderId);
        PaymentDetails payment =
                phonePeService
                        .checkPaymentStatus(
                                merchantOrderId
                        );

        return ResponseEntity.ok(payment);
    }

    @GetMapping("/report")
    public ResponseEntity<List<PaymentReportDto>> getPaymentReport() {

        List<PaymentReportDto> report =
                paymentService.getPaymentReport();

        return ResponseEntity.ok(report);
    }
}