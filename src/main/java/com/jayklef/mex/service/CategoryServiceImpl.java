package com.jayklef.mex.service;

import com.jayklef.mex.dto.CategoryDTO;
import com.jayklef.mex.entity.Category;
import com.jayklef.mex.exception.CategoryNotFoundException;
import com.jayklef.mex.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(CategoryDTO categoryDTO) {

        Category newCategory = Category.builder()
                .name(categoryDTO.getName())
                .build();
        return categoryRepository.save(newCategory);
    }

    @Override
    public Category updateCategory(Long categoryId, Category category) {

        Category categoryInDb = categoryRepository.findById(categoryId).get();

        if (Objects.nonNull(category.getName()) &&
        !"".equalsIgnoreCase(category.getName())){
            categoryInDb.setName(categoryInDb.getName());
        }

        if (Objects.nonNull(category.getHouses()) &&
        !"".equalsIgnoreCase(category.getHouses().toString())){
            categoryInDb.setHouses(categoryInDb.getHouses());
        }
        return categoryRepository.save(categoryInDb);
    }

    @Override
    public Category findCategoryById(Long categoryId) throws CategoryNotFoundException {

        Optional<Category> category = categoryRepository.findById(categoryId);

        if (category == null){
            throw new CategoryNotFoundException(String.format("Category with %s, not found", categoryId));
        }
        return categoryRepository.findById(categoryId).get();
    }
}
