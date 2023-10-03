package com.godsonjonathan.productservice.serviceImpl;

import com.godsonjonathan.productservice.Repository.ProductRepository;
import com.godsonjonathan.productservice.dto.ProductRequest;
import com.godsonjonathan.productservice.dto.ProductResponse;
import com.godsonjonathan.productservice.model.Product;
import com.godsonjonathan.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(new BigDecimal(productRequest.getPrice()))
                .build();

        productRepository.save(product);
        log.info("Product saved Successfully");
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        List<Product> allProduct = productRepository.findAll();

        return allProduct.stream().map(product -> mapToProductResponse(product)).toList();
    }

    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
