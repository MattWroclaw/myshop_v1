package com.mateusz.shopv1.myshop_v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProductController {
    @GetMapping
    public String productsList(){
        return "products";
    }
}
