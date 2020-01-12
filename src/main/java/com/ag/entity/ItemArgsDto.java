package com.ag.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemArgsDto {
    private String productId;//商品id
    private Integer productQuantity;//商品数量
}
