package com.jayklef.mex.service;

import com.jayklef.mex.dto.CategoryDTO;
import com.jayklef.mex.entity.Category;
import com.jayklef.mex.exception.CategoryNotFoundException;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category saveCategory(CategoryDTO categoryDTO);

    Category updateCategory(Long categoryId, Category category);

    Category findCategoryById(Long categoryId) throws CategoryNotFoundException;
}
