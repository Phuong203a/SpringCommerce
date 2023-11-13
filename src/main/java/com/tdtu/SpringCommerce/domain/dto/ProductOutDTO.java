package com.tdtu.SpringCommerce.domain.dto;

import com.tdtu.SpringCommerce.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOutDTO  extends BaseOutDTO{
    List<Product> productList;
}
