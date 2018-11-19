package ru.epatko.redislistener.repository;

import ru.epatko.redislistener.model.RedisPaymentData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<RedisPaymentData, String> {
}
