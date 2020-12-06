package com.codeblog.service;

import java.util.List;

public interface DefaultService<E> {
    List<E> findAll();
    E findById(Long id);
    E save(E entity);
}
