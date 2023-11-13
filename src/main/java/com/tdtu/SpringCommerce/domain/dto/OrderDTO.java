package com.tdtu.SpringCommerce.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements Serializable {
    private Long id;
    private Date date;
    private Long userId;
    private Double tax;
    private Double shipPrice;
    private Double totalPrice;
    private Double totalPriceFinal;
}
