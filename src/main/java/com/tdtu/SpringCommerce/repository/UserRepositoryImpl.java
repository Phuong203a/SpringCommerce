package com.tdtu.SpringCommerce.repository;

import com.tdtu.SpringCommerce.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryImpl implements UserRepositoryCustom {
    @Override
    public User findUserByUsername(String userName) {

        return null;
    }
}
