package com.godsonjonathan.productservice.controller;

import com.godsonjonathan.productservice.dto.ProductRequest;
import com.godsonjonathan.productservice.dto.ProductResponse;
import com.godsonjonathan.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse>  getAllProduct(){
        return productService.getAllProduct();
    }
}
