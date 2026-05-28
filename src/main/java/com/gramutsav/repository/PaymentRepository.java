package com.gramutsav.repository;

import com.gramutsav.entity.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository
        extends JpaRepository<PaymentDetails, Long> {

    PaymentDetails findByOrderId(String orderId);

    @Query(value = """
            SELECT\s
                ROW_NUMBER() OVER (ORDER BY pd.id) AS sr_no,
                pd.shares_no AS sabhasad_kramank,
                STRING_AGG(DISTINCT km.khatedar_navn, ', ') AS names,
                pd.mobile_no,
                pd.payment_date,
                pd.amount,
                pd.receipt_no
            FROM payment_details pd
            JOIN khatedar_mahiti km
            ON km.khate_kramank = ANY (
                  CAST(string_to_array(pd.shares_no, ',') AS integer[])
               )
            WHERE pd.payment_status = 'SUCCESS'
            GROUP BY
                pd.id,
                pd.shares_no,
                pd.mobile_no,
                pd.payment_date,
                pd.amount,
                pd.receipt_no
            ORDER BY pd.payment_date ASC;
        """, nativeQuery = true)
    List<Object[]> getPaymentSuccessReport();
}