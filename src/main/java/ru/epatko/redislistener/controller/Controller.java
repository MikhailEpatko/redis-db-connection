package ru.epatko.redislistener.controller;

import ru.epatko.redislistener.model.Data;
import ru.epatko.redislistener.model.Details;
import ru.epatko.redislistener.model.RedisPaymentData;
import ru.epatko.redislistener.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class Controller {

    private final RedisService service;

    @Autowired
    public Controller(RedisService service) {
        this.service = service;
    }

    @GetMapping("/one")
    public RedisPaymentData getOne() {
        Details details = new Details("_transactionId_", "_currency_", BigDecimal.valueOf(10.33D));
        Data data = new Data("_ID_", "_customerId_", "_tenantId_", "_type_", details);
        return new RedisPaymentData("_requestId_", data);
    }

    @GetMapping("/{requestId}")
    public RedisPaymentData getData(@PathVariable String requestId) {
        return service.read(requestId);
    }


    @PostMapping
    public RedisPaymentData saveData(@RequestBody RedisPaymentData paymentData) {
        return service.create(paymentData);
    }

    @PutMapping
    public RedisPaymentData updateData(@RequestBody RedisPaymentData paymentData){
        return  service.update(paymentData);
    }

    @DeleteMapping("/{requestId}")
    public void deleteData(@PathVariable String requestId) {
        service.delete(requestId);
    }
}
