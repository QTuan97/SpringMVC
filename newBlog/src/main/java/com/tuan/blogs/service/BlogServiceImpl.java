package com.tuan.blogs.service;

import com.tuan.blogs.model.Blog;
import com.tuan.blogs.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll(){
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id){
        return blogRepository.findById(id);
    }

    @Override
    public void save (Blog blog){
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id){
        blogRepository.remove(id);
    }
}
