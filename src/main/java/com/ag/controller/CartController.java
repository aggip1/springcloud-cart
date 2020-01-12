package com.ag.controller;

import com.ag.entity.*;
import com.ag.feign.CartFeign;
import com.ag.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("requestId")
    public String requestId(String id, HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        //从session获取到购物车
        Cart cart = (Cart) servletContext.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        Cart cart1 = cartService.addCart(id, cart);

        servletContext.setAttribute("cart", cart1);
        return "购买成功";
    }

    @Autowired
    private CartFeign cartFeign;
    @RequestMapping("getCart")
    public OrderResultDto getCart(HttpSession session) {
        ServletContext context = session.getServletContext();
        //获取到购物车
        Cart cart = (Cart) context.getAttribute("cart");
        ArrayList<ItemArgsDto> dtos = new ArrayList<>();
        //遍历购物车的购物项
        Map<String, Item> items = cart.getItems();
        for (String s : items.keySet()) {
            Integer count = items.get(s).getCount();
            ItemArgsDto itemArgsDto = new ItemArgsDto(items.get(s).getProductInfo().getProductId(),count);
            dtos.add(itemArgsDto);
            System.out.println("id"+items.get(s).getProductInfo().getProductId());
        }
        OrderDtoArgs args = new OrderDtoArgs("zsw","170","浙江宁波","12312",dtos);
        System.out.println("cart=====:"+args);
        OrderResultDto orderResultDto = cartFeign.toOrder(args);

        return orderResultDto;
    }

}
