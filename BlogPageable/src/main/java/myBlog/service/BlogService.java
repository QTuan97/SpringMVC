package myBlog.service;

import myBlog.model.Blog;
import myBlog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findbyId(Long id);
    void save(Blog blog);
    void remove(Long id);
    Iterable<Blog> findAllByCategory(Category category);
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}
