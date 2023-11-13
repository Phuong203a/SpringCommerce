package com.tdtu.SpringCommerce.service.impl;

import com.tdtu.SpringCommerce.DataUtil.Const;
import com.tdtu.SpringCommerce.domain.Product;
import com.tdtu.SpringCommerce.domain.dto.CartDTO;
import com.tdtu.SpringCommerce.repository.ProductRepository;
import com.tdtu.SpringCommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public void adjustCart(Model model, HttpSession session, Long proId, Long action) {
        HashMap<Long, CartDTO> cartItems = (HashMap<Long, CartDTO>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }

        Product product = productRepository.findById(proId).orElse(null);
        CartDTO item = cartItems.containsKey(proId) ? cartItems.get(proId) : new CartDTO();

        if(action.equals(Const.IS_ADD_TO_CART)) {
            item.setProductId(proId);
            item.setPrice(product.getPrice());
            item.setProductName(product.getName());
            item.setQuantity(cartItems.containsKey(proId) ? item.getQuantity() + 1 : 1);
            item.setTotalProductPrice(product.getPrice() * item.getQuantity());
            cartItems.put(proId, item);
        }else if(action.equals(Const.IS_SUB_TO_CART)){
            item.setProductId(proId);
            item.setPrice(product.getPrice());
            item.setProductName(product.getName());
            item.setQuantity(cartItems.containsKey(proId) ? item.getQuantity() - 1 : 0);
            item.setTotalProductPrice(product.getPrice() * item.getQuantity());
            cartItems.put(proId, item);
        }else if (action.equals(Const.IS_DELETE_TO_CART)){
            cartItems.remove(proId);
        }

        final double[] totalCartPrice = {0};


        cartItems.forEach(((key, value) -> totalCartPrice[0] += value.getTotalProductPrice()));

        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("totalCartPrice", totalCartPrice[0]);
        session.setAttribute("tax", totalCartPrice[0]* Const.TAX);
        session.setAttribute("totalCartPriceTax", totalCartPrice[0]*(1+Const.TAX)+Const.SHIP_PRICE);
    }
}
