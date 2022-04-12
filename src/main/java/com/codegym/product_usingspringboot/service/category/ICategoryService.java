package com.codegym.product_usingspringboot.service.category;


import com.codegym.product_usingspringboot.model.Category;
import com.codegym.product_usingspringboot.model.Product;
import com.codegym.product_usingspringboot.service.IGenneralService;

public interface ICategoryService extends IGenneralService<Category> {
    Iterable<Product> productsFindByCategoryId(Long id);
    void deleteByProcedure(Long category_id);
}
