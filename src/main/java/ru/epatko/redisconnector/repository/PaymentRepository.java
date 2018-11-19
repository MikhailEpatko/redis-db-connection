package ru.epatko.redisconnector.repository;

import ru.epatko.redisconnector.model.RedisPaymentData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<RedisPaymentData, String> {
}
