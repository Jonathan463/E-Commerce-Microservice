package com.godsonjonathan.productservice.service;

import com.godsonjonathan.productservice.dto.ProductRequest;
import com.godsonjonathan.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProduct();
}
