package com.codegym.product_usingspringboot.service;

import java.util.Optional;

public interface IGenneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void removeById(Long id);
}
