package com.ag.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderResultDto {
    private Integer code;
    private String msg;
    private OrderData data;
}
