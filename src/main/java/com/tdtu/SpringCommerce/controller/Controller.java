package com.tdtu.SpringCommerce.controller;

import com.tdtu.SpringCommerce.DataUtil.Const;
import com.tdtu.SpringCommerce.domain.dto.CartDTO;
import com.tdtu.SpringCommerce.service.CartService;
import com.tdtu.SpringCommerce.service.OrderService;
import com.tdtu.SpringCommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller

public class Controller {
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
    @Autowired
    CartService cartService;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("productGroups", productService.getProductByColumn());
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @GetMapping("/cart")
    public String cart(Model model, HttpSession session) {
        HashMap<Long, CartDTO> cartItems = (HashMap<Long, CartDTO>) session.getAttribute("myCartItems");

        List<Map.Entry<Long, CartDTO>> entryList = cartItems == null ? new ArrayList<>() : new ArrayList<>(cartItems.entrySet());
        boolean isCartEmpty = entryList.isEmpty();
        model.addAttribute("isCartEmpty", isCartEmpty);
        model.addAttribute("cartItems", entryList);
        model.addAttribute("totalCartPrice", session.getAttribute("totalCartPrice"));
        model.addAttribute("tax", session.getAttribute("tax"));
        model.addAttribute("totalCartPriceTax", session.getAttribute("totalCartPriceTax"));
        model.addAttribute("shipPrice", Const.SHIP_PRICE);

        return "cart";
    }

    @PostMapping("/adjustCart")
    public String adjustCart(Model model, HttpSession session, @RequestParam("productId") Long proId,
                            @RequestParam Long action) {
        cartService.adjustCart(model,session,proId,action);
        return "redirect:/cart";
    }

    @PostMapping("/checkOut")
    public String checkOut(Model model, HttpSession session) {
        orderService.checkOut(model,session);
        return "redirect:/home";
    }
}
