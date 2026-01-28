package service;

import com.example.ecommerce.modal.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    String createCategory(Category category);

    void deleteCategory(Long categoryId);

    Category updateCategory(Category category,Long categoryId);
}
