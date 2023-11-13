package com.tdtu.SpringCommerce.service.impl;

import com.tdtu.SpringCommerce.DataUtil.Const;
import com.tdtu.SpringCommerce.domain.OrderCart;
import com.tdtu.SpringCommerce.domain.OrderItem;
import com.tdtu.SpringCommerce.domain.Product;
import com.tdtu.SpringCommerce.domain.dto.CartDTO;
import com.tdtu.SpringCommerce.domain.dto.OrderDTO;
import com.tdtu.SpringCommerce.repository.OrderCartRepository;
import com.tdtu.SpringCommerce.repository.OrderItemRepository;
import com.tdtu.SpringCommerce.repository.ProductRepository;
import com.tdtu.SpringCommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderCartRepository orderCartRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    ProductRepository productRepository;
    @Override
    public void checkOut(Model model, HttpSession session) {
        HashMap<Long, CartDTO> cartItems = (HashMap<Long, CartDTO>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            return;
        }
        if(session.getAttribute("totalCartPrice") == null||
                session.getAttribute("tax") == null||
                session.getAttribute("totalCartPriceTax") == null){
            return;
        }
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setDate(new Date());
        orderDTO.setTax(Double.valueOf(session.getAttribute("tax").toString()));
        orderDTO.setShipPrice(Const.SHIP_PRICE);
        orderDTO.setTotalPrice(Double.valueOf(session.getAttribute("totalCartPrice").toString()));
        orderDTO.setTotalPriceFinal(Double.valueOf(session.getAttribute("totalCartPriceTax").toString()));
        orderDTO.setUserId(1L);
        OrderCart orderCart = orderCartRepository.save(new OrderCart(orderDTO));


        List<OrderItem> orderItemList= new ArrayList<>();

        cartItems.forEach((productId,item)->{
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderCart.getId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setProductId(item.getProductId());
            orderItem.setPrice(item.getTotalProductPrice());
            orderItemList.add(orderItem);
        });
        orderItemRepository.saveAll(orderItemList);
    }
}
