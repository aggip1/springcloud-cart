package com.ag.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    private String id;//id
    private ProductInfo productInfo;//商品
    private Double smallTotal;//小计
    private Integer count;//数量

}
