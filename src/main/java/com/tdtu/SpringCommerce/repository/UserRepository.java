package com.tdtu.SpringCommerce.repository;

import com.tdtu.SpringCommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>,UserRepositoryCustom {
    User findByUserName(String name);
}
