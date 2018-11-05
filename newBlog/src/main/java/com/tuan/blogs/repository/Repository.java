package com.tuan.blogs.repository;
import java.util.List;

public interface Repository <T> {
    List<T> findAll();

    T findById(Long id);

    void save(T blog);

    void remove(Long id);
}
