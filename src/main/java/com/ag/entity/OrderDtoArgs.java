package com.ag.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDtoArgs {

    private String  name;
    private String phone;
    private String address;
    private String openid;
    private List<ItemArgsDto> items;
}
