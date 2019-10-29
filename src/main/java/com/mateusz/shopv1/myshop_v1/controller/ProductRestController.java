package com.mateusz.shopv1.myshop_v1.controller;

import com.mateusz.shopv1.myshop_v1.entity.Product;
import com.mateusz.shopv1.myshop_v1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductRestController {
    private final ProductService productService;

    @GetMapping
    public Collection<Product> products(@RequestParam(required = false) String filter){
        return productService.findAll(filter);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productService.find(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product editProduct(@RequestBody Product product,
                                @PathVariable Long id){
        product.setId(id);
       return productService.editProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.delete(id);
    }
}
