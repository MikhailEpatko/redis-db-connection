package ru.epatko.redislistener.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Details {
    private String transactionId;
    private String currency;
    private BigDecimal amount;
}
