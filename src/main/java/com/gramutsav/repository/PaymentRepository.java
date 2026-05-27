package com.gramutsav.repository;

import com.gramutsav.entity.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository
        extends JpaRepository<PaymentDetails, Long> {

    PaymentDetails findByOrderId(
            String orderId
    );
}