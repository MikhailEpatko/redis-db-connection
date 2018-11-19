package ru.epatko.redisconnector.service;

import com.google.gson.Gson;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import ru.epatko.redisconnector.model.RedisPaymentData;
import ru.epatko.redisconnector.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private final PaymentRepository paymentRepository;
    private final StringRedisTemplate redisTemplate;
    private Gson gson = new Gson();

    @Autowired
    public RedisService(PaymentRepository paymentRepository, StringRedisTemplate redisTemplate) {
        this.paymentRepository = paymentRepository;
        this.redisTemplate = redisTemplate;
    }

    public RedisPaymentData create(RedisPaymentData paymentData) {
        return paymentRepository.save(paymentData);
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

    public String getLikeJson(String requestId) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        return ops.get(requestId);
    }

    public void saveLikeJson(RedisPaymentData paymentData) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(paymentData.getRequestId(), gson.toJson(paymentData.getData()));
    }
}