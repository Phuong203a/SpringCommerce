package com.tdtu.SpringCommerce.repository;

import com.tdtu.SpringCommerce.domain.User;

public interface UserRepositoryCustom {
    User findUserByUsername(String userName);
}
