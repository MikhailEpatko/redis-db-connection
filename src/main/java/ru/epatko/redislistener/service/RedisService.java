package ru.epatko.redislistener.service;

import ru.epatko.redislistener.model.RedisPaymentData;
import ru.epatko.redislistener.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public RedisService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public RedisPaymentData create(RedisPaymentData paymentData) {
        RedisPaymentData pd = paymentRepository.save(paymentData);
        return  pd;
    }

    public RedisPaymentData read(String requestId) {
        return paymentRepository.findById(requestId).orElse(null);
    }

    public void delete(String requestId) {
        paymentRepository.deleteById(requestId);
    }

    public RedisPaymentData update(RedisPaymentData newPaymentData) {
        return paymentRepository.save(newPaymentData);
    }
}