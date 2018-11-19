package ru.epatko.redisconnector.controller;

import ru.epatko.redisconnector.model.Data;
import ru.epatko.redisconnector.model.Details;
import ru.epatko.redisconnector.model.RedisPaymentData;
import ru.epatko.redisconnector.service.RedisService;
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
        Data data = new Data("_ID_", "_customerId_", "_tenantId_", "payment", details);
        return new RedisPaymentData("_requestId_", data);
    }

    @GetMapping("/tmp/{requestId}")
    public String gettmp(@PathVariable String requestId) {
        String s = service.gettmp(requestId);
        return s;
    }

    @GetMapping("/{requestId}")
    public RedisPaymentData getData(@PathVariable String requestId) {
        return service.read(requestId);
    }


    @PostMapping
    public RedisPaymentData saveData(@RequestBody RedisPaymentData paymentData) {
        return service.create(paymentData);
    }

    @PostMapping("/tmp")
    public void saveTmp(@RequestBody RedisPaymentData paymentData) {
        service.savetmp(paymentData);
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
