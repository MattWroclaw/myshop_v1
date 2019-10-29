package com.mateusz.shopv1.myshop_v1.controller;

import com.mateusz.shopv1.myshop_v1.entity.Product;
import com.mateusz.shopv1.myshop_v1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.omg.CORBA.INTERNAL;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductRestController {
    private final ProductService productService;


//    @GetMapping
//    public List<Product> findAllOld(@RequestParam(required = false) String filter){
//        return productService.findOldVer(filter);
//    }


//      TODO rozkminić o co chodzi z filtrowaniem po wielu argumentach
    @GetMapping
    public List<Product> findAll(@RequestParam(required = false)String filter,
                                 @RequestParam(required = false) Integer pageIndex,
                                 @RequestParam(required = false) Integer pageSize,
                                 @RequestParam(required = false) String sortDirection,
                                 @RequestParam(required = false) String sortColumn){
        return productService.findAll(filter, pageIndex, pageSize, sortDirection, sortColumn);
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
