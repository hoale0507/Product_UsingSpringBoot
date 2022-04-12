package com.codegym.product_usingspringboot.service.product;


import com.codegym.product_usingspringboot.model.Category;
import com.codegym.product_usingspringboot.model.Product;
import com.codegym.product_usingspringboot.service.IGenneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGenneralService<Product> {
    Page<Product> searchProductByPartOfName(String name, Pageable pageable);
    Iterable<Product> searchProductByPriceAndName(Double min, Double max);
    Iterable<Product> findAllByCategory(Category category);
    Page<Product> findAll(Pageable pageable);
    Iterable<Product> findByNameContaining(String name);

}
