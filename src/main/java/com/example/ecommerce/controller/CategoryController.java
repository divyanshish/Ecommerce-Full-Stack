package com.example.ecommerce.controller;

import com.example.ecommerce.modal.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CategoryService;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;



    @GetMapping("/api/public/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.createCategory(category),HttpStatus.CREATED);
    }

    @DeleteMapping("api/public/categories/{categoryId}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>( "Category deleted Successfully",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,
    @PathVariable Long categoryId){
        categoryService.updateCategory(category,categoryId);
        return  new ResponseEntity<>("Category Updated Successfully",HttpStatus.OK);
    }


}
