package com.codegym.product_usingspringboot.repository;


import com.codegym.product_usingspringboot.model.Category;
import com.codegym.product_usingspringboot.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
    Page<Product> findByNameContaining(String name, Pageable pageable);
    @Query(value = "select * from products where price between ?1 and ?2",nativeQuery = true)
    Iterable<Product> searchProductByPriceAndName(Double min, Double max);
    Iterable<Product> findAllByCategory(Category category);
    Iterable<Product> findByNameContaining(String name);
}
