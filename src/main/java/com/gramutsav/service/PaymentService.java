package com.gramutsav.service;

import com.gramutsav.dto.PaymentReportDto;
import com.gramutsav.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<PaymentReportDto> getPaymentReport() {

        List<Object[]> rows = paymentRepository.getPaymentSuccessReport();

        List<PaymentReportDto> reportList = new ArrayList<>();

        for (Object[] row : rows) {

            PaymentReportDto dto = new PaymentReportDto();

            dto.setSrNo(((Number) row[0]).longValue());
            dto.setSabhasadKramank((String) row[1]);
            dto.setNames((String) row[2]);
            dto.setMobileNo((String) row[3]);
            dto.setPaymentDate((Date) row[4]);
            dto.setAmount(row[5] != null ? ((Number) row[5]).doubleValue() : 0.0);
            dto.setReceiptNo((String) row[6]);

            reportList.add(dto);
        }

        return reportList;
    }
}