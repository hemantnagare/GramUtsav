package com.gramutsav.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PaymentDetailsid;

    private String orderId;

    private String phonePeOrderId;

    private String mobileNo;

    private String sharesNo;

    private Long amount;

    private String paymentStatus;

    private Long expireAt;

    @Column(length = 5000)
    private String redirectUrl;

    private LocalDateTime paymentDate;

    public Long getPaymentDetailsid() {
        return PaymentDetailsid;
    }

    public void setPaymentDetailsid(Long paymentDetailsid) {
        PaymentDetailsid = paymentDetailsid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPhonePeOrderId() {
        return phonePeOrderId;
    }

    public void setPhonePeOrderId(String phonePeOrderId) {
        this.phonePeOrderId = phonePeOrderId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getSharesNo() {
        return sharesNo;
    }

    public void setSharesNo(String sharesNo) {
        this.sharesNo = sharesNo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Long expireAt) {
        this.expireAt = expireAt;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}