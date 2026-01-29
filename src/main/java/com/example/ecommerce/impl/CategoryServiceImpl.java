package com.example.ecommerce.impl;

import com.example.ecommerce.modal.Category;
import com.example.ecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public String createCategory(Category category) {

        categoryRepository.save(category);
        return "Categories Added Successfully";
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category doesn't exist"));

//        List<Category> categories = categoryRepository.findAll();
//        Category category = categories.stream().filter(c-> c.getCategoryId().equals(categoryId)).findFirst().orElse(null);

        categoryRepository.delete(category);


    }

    @Override
    public Category updateCategory(Category category,Long categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        Category savedCategory = optionalCategory.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category doesn't exist"));
        savedCategory.setCategoryId(categoryId);
        savedCategory.setCategoryName(category.getCategoryName());
        return categoryRepository.save(savedCategory);
        //List<Category> categories = categoryRepository.findAll();
//
//        Optional<Category> optionalCategory = categories.stream().filter(c-> c.getCategoryId().equals(categoryId)).findFirst();
//        if(optionalCategory.isPresent()){
//            Category existingCategory = optionalCategory.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//            Category savedCategory = categoryRepository.save(existingCategory);
//            return savedCategory;
//        }else
//        return null;

    }
}
