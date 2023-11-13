package com.tdtu.SpringCommerce.repository;

import com.tdtu.SpringCommerce.domain.OrderCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCartRepository extends JpaRepository<OrderCart,Long> {
}
