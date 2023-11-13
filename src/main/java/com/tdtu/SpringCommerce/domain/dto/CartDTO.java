package com.tdtu.SpringCommerce.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private Long productId;
    private String productName;
    private double price;
    private int quantity;
    private double totalProductPrice;
}
