package com.tdtu.SpringCommerce.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface OrderService {
    void checkOut(Model model, HttpSession session);

}
