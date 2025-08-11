package com.example.Insurance.Service;

import com.example.Insurance.Model.Payment;
import com.example.Insurance.Model.InsurancePolicy;
import com.example.Insurance.Repository.PaymentRepository;
import com.example.Insurance.Repository.InsurancePolicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private InsurancePolicyRepo insurancePolicyRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment createPayment(Payment payment) {
        if (payment.getPolicyId() == null) {
            throw new IllegalArgumentException("Policy ID is required");
        }

        Optional<InsurancePolicy> policyOptional = insurancePolicyRepository.findById(payment.getPolicyId());
        if (!policyOptional.isPresent()) {
            throw new RuntimeException("Policy not found with id: " + payment.getPolicyId());
        }

        payment.setPolicy(policyOptional.get());
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment paymentDetails) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));

        payment.setPaymentAmount(paymentDetails.getPaymentAmount());
        payment.setPaymentStatus(paymentDetails.getPaymentStatus());

        if (paymentDetails.getPolicyId() != null && !paymentDetails.getPolicyId().equals(payment.getPolicyId())) {
            Optional<InsurancePolicy> policyOptional = insurancePolicyRepository.findById(paymentDetails.getPolicyId());
            if (!policyOptional.isPresent()) {
                throw new RuntimeException("Policy not found with id: " + paymentDetails.getPolicyId());
            }
            payment.setPolicy(policyOptional.get());
            payment.setPolicyId(paymentDetails.getPolicyId());
        }

        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
