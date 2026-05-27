package com.gramutsav.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "khatedar_mahiti")
public class KhatedarMahiti {

    @Id
    @GeneratedValue(
            strategy =
                    GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "khate_kramank")
    private Integer khateKramank;

    @Column(name = "khate_prakar")
    private String khatePrakar;

    @Column(name = "krushik_kshetra")
    private BigDecimal krushikKshetra;

    @Column(name = "potkharab_kshetra")
    private BigDecimal potkharabKshetra;

    @Column(name = "ekun_kshetra")
    private BigDecimal ekunKshetra;

    @Column(name = "akarani")
    private BigDecimal akarani;

    @Column(name = "khatedar_navn")
    private String khatedarNavn;

    @Column(name = "survey_kramank")
    private String surveyKramank;

    @Column(name = "mobile_no")
    private String mobileNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKhateKramank() {
        return khateKramank;
    }

    public void setKhateKramank(
            Integer khateKramank
    ) {
        this.khateKramank =
                khateKramank;
    }

    public String getKhatePrakar() {
        return khatePrakar;
    }

    public void setKhatePrakar(
            String khatePrakar
    ) {
        this.khatePrakar =
                khatePrakar;
    }

    public BigDecimal getKrushikKshetra() {
        return krushikKshetra;
    }

    public void setKrushikKshetra(
            BigDecimal krushikKshetra
    ) {
        this.krushikKshetra =
                krushikKshetra;
    }

    public BigDecimal getPotkharabKshetra() {
        return potkharabKshetra;
    }

    public void setPotkharabKshetra(
            BigDecimal potkharabKshetra
    ) {
        this.potkharabKshetra =
                potkharabKshetra;
    }

    public BigDecimal getEkunKshetra() {
        return ekunKshetra;
    }

    public void setEkunKshetra(
            BigDecimal ekunKshetra
    ) {
        this.ekunKshetra =
                ekunKshetra;
    }

    public BigDecimal getAkarani() {
        return akarani;
    }

    public void setAkarani(
            BigDecimal akarani
    ) {
        this.akarani =
                akarani;
    }

    public String getKhatedarNavn() {
        return khatedarNavn;
    }

    public void setKhatedarNavn(
            String khatedarNavn
    ) {
        this.khatedarNavn =
                khatedarNavn;
    }

    public String getSurveyKramank() {
        return surveyKramank;
    }

    public void setSurveyKramank(
            String surveyKramank
    ) {
        this.surveyKramank =
                surveyKramank;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(
            String mobileNo
    ) {
        this.mobileNo =
                mobileNo;
    }
}