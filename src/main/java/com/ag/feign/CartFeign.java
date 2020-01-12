package com.ag.feign;

import com.ag.entity.OrderDtoArgs;
import com.ag.entity.OrderResultDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "ORDER",url = "http://localhost:9003")
public interface CartFeign {
    @RequestMapping("order/create")
    public OrderResultDto toOrder(OrderDtoArgs args);
}
