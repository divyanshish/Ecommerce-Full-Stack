package com.example.ecommerce.impl;

import com.example.ecommerce.modal.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private Long id = 1L;

    private final List<Category> categories;
    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public String createCategory(Category category) {
        category.setCategoryId(++id);
        categories.add(category);
        return "Categories Added Successfully";
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categories.stream().filter(c-> c.getCategoryId().equals(categoryId)).findFirst().orElse(null);
        categories.remove(category);


    }

    @Override
    public Category updateCategory(Category category,Long categoryId) {
        Optional<Category> optionalCategory = categories.stream().filter(c-> c.getCategoryId().equals(categoryId)).findFirst();
        if(optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            return existingCategory;
        }
        return null;
    }
}
