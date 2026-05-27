package com.gramutsav.entity;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "shareholder")
public class ShareHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Shareid;
    private String ShareNo;
    private String firstname;
    private String middlename;
    private String lastname;
    private String mobilenumber;
    private String email;


    public Long getShareid() {
        return Shareid;
    }

    public void setShareid(Long shareid) {
        Shareid = shareid;
    }

    public String getShareNo() {
        return ShareNo;
    }

    public void setShareNo(String shareNo) {
        ShareNo = shareNo;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}