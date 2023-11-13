package com.tdtu.SpringCommerce.service.impl;

import com.tdtu.SpringCommerce.domain.Product;
import com.tdtu.SpringCommerce.repository.ProductRepository;
import com.tdtu.SpringCommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<List<Product>> getProductByColumn() {
        List<Product> productList = productRepository.findAll();
        List<List<Product>> productGroups = new ArrayList<>();
        List<Product> group = new ArrayList<>();

        for (Product product : productList) {
            group.add(product);
            if (group.size() == 3) {
                productGroups.add(group);
                group = new ArrayList<>();
            }
        }

        if (!group.isEmpty()) {
            productGroups.add(group);
        }
        return productGroups;
    }
}
