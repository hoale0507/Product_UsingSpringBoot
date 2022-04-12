package com.codegym.product_usingspringboot.service.category;


import com.codegym.product_usingspringboot.model.Category;
import com.codegym.product_usingspringboot.model.Product;
import com.codegym.product_usingspringboot.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void removeById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> productsFindByCategoryId(Long id) {
        return categoryRepository.productsFindByCategoryId(id);
    }

    @Override
    public void deleteByProcedure(Long category_id) {
        categoryRepository.deleteByProcedure(category_id);
    }
}
