package com.gramutsav.dto;

import lombok.Data;

import java.util.List;

@Data
public class PaymentRequest {

    private List<String> sharesNo;

    private String mobileNo;

    private Long amount;

    public List<String> getSharesNo() {
        return sharesNo;
    }

    public void setSharesNo(List<String> sharesNo) {
        this.sharesNo = sharesNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}