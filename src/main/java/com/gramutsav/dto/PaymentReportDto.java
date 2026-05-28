package com.gramutsav.dto;

import java.util.Date;

public class PaymentReportDto {

    private Long srNo;
    private String sabhasadKramank;
    private String names;
    private String mobileNo;
    private Date paymentDate;
    private Double amount;
    private String receiptNo;

    public PaymentReportDto() {
    }

    public PaymentReportDto(Long srNo,
                            String sabhasadKramank,
                            String names,
                            String mobileNo,
                            Date paymentDate,
                            Double amount,
                            String receiptNo) {
        this.srNo = srNo;
        this.sabhasadKramank = sabhasadKramank;
        this.names = names;
        this.mobileNo = mobileNo;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.receiptNo = receiptNo;
    }

    public Long getSrNo() {
        return srNo;
    }

    public void setSrNo(Long srNo) {
        this.srNo = srNo;
    }

    public String getSabhasadKramank() {
        return sabhasadKramank;
    }

    public void setSabhasadKramank(String sabhasadKramank) {
        this.sabhasadKramank = sabhasadKramank;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }
}