package com.smart.smartcontactmanager;

import com.smart.smartcontactmanager.models.Category;
import com.smart.smartcontactmanager.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CategoryService {

    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();

    }
    public Category getCategoryById(long cId) {
        Optional optional=categoryRepository.findById(cId);
        if (optional.isPresent()){
            return(Category)optional.get();

        }
        return null;
    }


    public void deleteCategoryById(long cId) {
        categoryRepository.deleteById(cId);
    }

    public Category getCategoryByName(String categoryName) {

        return categoryRepository.findByCategoryName(categoryName);

    }
}
