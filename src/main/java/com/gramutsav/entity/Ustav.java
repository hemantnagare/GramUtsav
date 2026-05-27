package com.gramutsav.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ustav")
public class Ustav {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ustavid;

    private String ustavname;

    private LocalDate ustavMeetingDate;

    private LocalDate ustavStartDate;

    private LocalDate ustavEndDate;

    private LocalDate ustavPaymentStartDate;

    private LocalDate ustavPaymentEndDate;

    private Double amount;

    public Long getUstavid() {
        return ustavid;
    }

    public void setUstavid(Long ustavid) {
        this.ustavid = ustavid;
    }

    public String getUstavname() {
        return ustavname;
    }

    public void setUstavname(String ustavname) {
        this.ustavname = ustavname;
    }

    public LocalDate getUstavMeetingDate() {
        return ustavMeetingDate;
    }

    public void setUstavMeetingDate(LocalDate ustavMeetingDate) {
        this.ustavMeetingDate = ustavMeetingDate;
    }

    public LocalDate getUstavStartDate() {
        return ustavStartDate;
    }

    public void setUstavStartDate(LocalDate ustavStartDate) {
        this.ustavStartDate = ustavStartDate;
    }

    public LocalDate getUstavEndDate() {
        return ustavEndDate;
    }

    public void setUstavEndDate(LocalDate ustavEndDate) {
        this.ustavEndDate = ustavEndDate;
    }

    public LocalDate getUstavPaymentStartDate() {
        return ustavPaymentStartDate;
    }

    public void setUstavPaymentStartDate(LocalDate ustavPaymentStartDate) {
        this.ustavPaymentStartDate = ustavPaymentStartDate;
    }

    public LocalDate getUstavPaymentEndDate() {
        return ustavPaymentEndDate;
    }

    public void setUstavPaymentEndDate(LocalDate ustavPaymentEndDate) {
        this.ustavPaymentEndDate = ustavPaymentEndDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
