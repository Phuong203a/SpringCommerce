package com.tdtu.SpringCommerce.domain;

import com.tdtu.SpringCommerce.domain.dto.OrderDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "order_cart")
public class OrderCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "tax")
    private Double tax;
    @Column(name = "ship_price")
    private Double shipPrice;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "total_price_final")
    private Double totalPriceFinal;
    public OrderCart(OrderDTO dto) {
        this.id = dto.getId();
        this.date = dto.getDate();
        this.userId = dto.getUserId();
        this.tax = dto.getTax();
        this.shipPrice = dto.getShipPrice();
        this.totalPrice = dto.getTotalPrice();
        this.totalPriceFinal = dto.getTotalPriceFinal();
    }
}
