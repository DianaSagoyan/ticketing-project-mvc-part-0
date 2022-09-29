package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    private Long id;
    private LocalDateTime insertDateTime;
    protected Long insertUserId;
    protected LocalDateTime lastUpdateDateTime;
    private Long lastUpdateUserId;
}
