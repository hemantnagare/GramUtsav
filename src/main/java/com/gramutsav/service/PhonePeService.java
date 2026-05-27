package com.gramutsav.service;

import com.gramutsav.entity.PaymentDetails;
import com.gramutsav.repository.PaymentRepository;
import com.phonepe.sdk.pg.common.models.MetaInfo;
import com.phonepe.sdk.pg.payments.v2.StandardCheckoutClient;
import com.phonepe.sdk.pg.payments.v2.models.request.StandardCheckoutPayRequest;
import com.phonepe.sdk.pg.payments.v2.models.response.StandardCheckoutPayResponse;
import com.phonepe.sdk.pg.common.models.response.OrderStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PhonePeService {

    @Autowired
    private StandardCheckoutClient client;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private JavaMailSender mailSender;

    public String createPayment(
            String mobileNo,
            List<Integer> sharesNo,
            Long amount
    ) {

        try {

            String merchantOrderId =
                    "ORDER_" + UUID.randomUUID();

            MetaInfo metaInfo = MetaInfo.builder()
                    .udf1(mobileNo)
                    .build();

            StandardCheckoutPayRequest request =
                    StandardCheckoutPayRequest.builder()
                            .merchantOrderId(merchantOrderId)
                            .amount(amount * 100)
                            .redirectUrl(
                                    "http://localhost:5173/payment-success?merchantOrderId="
                                            + merchantOrderId
                            )
                            .metaInfo(metaInfo)
                            .expireAfter(3600L)
                            .build();

            // PHONEPE API CALL
            StandardCheckoutPayResponse response =
                    client.pay(request);

            System.out.println(response);

            // SAVE TO DATABASE
            PaymentDetails payment =
                    new PaymentDetails();

            payment.setOrderId(merchantOrderId);

            payment.setPhonePeOrderId(
                    response.getOrderId()
            );

            payment.setMobileNo(mobileNo);

            payment.setSharesNo(
                    sharesNo.stream()
                            .map(String::valueOf)
                            .collect(java.util.stream.Collectors.joining(","))
            );

            payment.setAmount(amount);

            payment.setPaymentStatus(
                    response.getState()
            );

            payment.setExpireAt(
                    response.getExpireAt()
            );

            payment.setRedirectUrl(
                    response.getRedirectUrl()
            );

            payment.setPaymentDate(
                    LocalDateTime.now()
            );

            paymentRepository.save(payment);

            return response.getRedirectUrl();

        } catch (Exception e) {

            e.printStackTrace();

            return "FAILED";
        }
    }

    public void sendPaymentMail(PaymentDetails payment)
    {
        SimpleMailMessage message =
                new SimpleMailMessage();

        message.setTo("hemantnagare10@gmail.com");

        message.setSubject(
                "GramUtsav Payment Initiated"
        );

        message.setText(
                "Payment Details\n\n" +

                        "Order ID : " +
                        payment.getOrderId() + "\n\n" +

                        "PhonePe Order ID : " +
                        payment.getPhonePeOrderId() + "\n\n" +

                        "Mobile No : " +
                        payment.getMobileNo() + "\n\n" +

                        "Shares No : " +
                        payment.getSharesNo() + "\n\n" +

                        "Amount : ₹" +
                        payment.getAmount() + "\n\n" +

                        "Status : " +
                        payment.getPaymentStatus() + "\n\n" +

                        "Date : " +
                        payment.getPaymentDate() + "\n\n"


        );
        System.out.println("mail message=>"+message);
        mailSender.send(message);
    }


    public PaymentDetails checkPaymentStatus(
            String merchantOrderId
    ) {
        System.out.println("api1 merchantOrderId=>"+merchantOrderId);
        PaymentDetails payment =paymentRepository.findByOrderId(merchantOrderId);

        try {

            OrderStatusResponse response =
                    client.getOrderStatus(
                            merchantOrderId
                    );

            System.out.println("api=>"+response);

            String state =
                    response.getState();

            if(state.equals("COMPLETED")) {

                payment.setPaymentStatus(
                        "SUCCESS"
                );

                paymentRepository.save(payment);
            }
            else if(state.equals("FAILED")) {

                payment.setPaymentStatus("FAILED");

                paymentRepository.save(payment);
            }
            else {

                payment.setPaymentStatus("PENDING");

                paymentRepository.save(payment);
            }
            // SEND SUCCESS MAIL
            sendPaymentMail(payment);
            return payment;

        }
        catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }
}