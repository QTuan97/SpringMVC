package blog.service;

import blog.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findbyId(Long id);
    void save(Blog blog);
    void remove(Long id);
}
