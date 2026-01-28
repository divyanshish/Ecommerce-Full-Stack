package com.example.ecommerce.controller;

import com.example.ecommerce.modal.Category;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class CategoryController {

    private List<Category> categories = new ArrayList<>();

    @GetMapping("/public/categories")
    public List<Category> getAllCategories(){
        return categories;
    }

}
