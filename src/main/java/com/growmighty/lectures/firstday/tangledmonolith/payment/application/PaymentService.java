package com.growmighty.lectures.firstday.tangledmonolith.payment.application;

import com.growmighty.lectures.firstday.tangledmonolith.payment.domain.Payment;
import com.growmighty.lectures.firstday.tangledmonolith.payment.domain.PaymentRepository;
import com.growmighty.lectures.firstday.tangledmonolith.payment.domain.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public Payment pay(BigDecimal totalAmount) {
        Payment payment = Payment.ready(totalAmount);
        payment.changeStatus(PaymentStatus.PAID);
        paymentRepository.save(payment);
        return payment;
    }
}
