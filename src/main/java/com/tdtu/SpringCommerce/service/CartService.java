package com.tdtu.SpringCommerce.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface CartService {
     void adjustCart(Model model, HttpSession session, Long proId, Long action);
}
