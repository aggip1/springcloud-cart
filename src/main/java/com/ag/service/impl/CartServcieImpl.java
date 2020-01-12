package com.ag.service.impl;

import com.ag.dao.ProductCartDao;
import com.ag.entity.Cart;
import com.ag.entity.Item;
import com.ag.entity.ProductInfo;
import com.ag.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartServcieImpl implements CartService {
    @Autowired
    private ProductCartDao productCartDao;
    @Override
    public Cart addCart(String id, Cart cart) {
        //根据id获取菜
        ProductInfo productInfo = productCartDao.productQueryById(id);
        //根据id获取到购物项
        Item item = cart.getItems().get(id);
        if(item==null){
            //创建一个购物项
            Item item1 = new Item();
            //设置数量
            item1.setCount(1);
            //设置商品
            item1.setProductInfo(productInfo);
            //设置小计
            item1.setSmallTotal(productInfo.getProductPrice());
            //获取到购物项   是map
            Map<String, Item> map = cart.getItems();
            //设置购物项==替换
            map.put(id,item1);
            if (cart.getTotalPrice()==null){
                cart.setTotalPrice(0.0);
            }
            cart.setTotalPrice(cart.getTotalPrice()+productInfo.getProductPrice());
            //将购物项放进购物车
            cart.setItems(map);
            System.out.println("第一次添加的总价"+cart.getTotalPrice());
        }else{
            item.setCount(item.getCount()+1);
            item.setSmallTotal(item.getCount()*productInfo.getProductPrice());
            cart.setTotalPrice(cart.getTotalPrice()+productInfo.getProductPrice());
            System.out.println("多次添加以后的小计"+item.getSmallTotal()+"--数量--"+item.getCount());
            System.out.println("多次添加以后的总价"+cart.getTotalPrice());
        }
        return cart;
    }
}
