package com.codegym.product_usingspringboot.service.product;


import com.codegym.product_usingspringboot.model.Category;
import com.codegym.product_usingspringboot.model.Product;
import com.codegym.product_usingspringboot.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void removeById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> searchProductByPartOfName(String name, Pageable pageable) {
        return productRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Iterable<Product> searchProductByPriceAndName(Double min, Double max) {
        return productRepository.searchProductByPriceAndName(min,max);
    }

    @Override
    public Iterable<Product> findAllByCategory(Category category) {
        return productRepository.findAllByCategory(category);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Iterable<Product> findByNameContaining(String name) {
        return productRepository.findByNameContaining(name);
    }

}