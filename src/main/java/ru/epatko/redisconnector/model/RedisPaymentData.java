package ru.epatko.redisconnector.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisPaymentData {

    @Id
    private String requestId;
    private ru.epatko.redisconnector.model.Data data;
}
