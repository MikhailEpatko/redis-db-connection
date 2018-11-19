package ru.epatko.redisconnector.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Data {
    private String id;
    private String customerId;
    private String tenantId;
    private String type;
    private Details details;
}
