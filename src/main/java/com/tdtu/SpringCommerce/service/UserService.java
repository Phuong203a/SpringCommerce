package com.tdtu.SpringCommerce.service;

import com.tdtu.SpringCommerce.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findUserByName(String userName);
}
