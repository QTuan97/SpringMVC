package myBlog.service.impl;

import myBlog.model.Blog;
import myBlog.model.Category;
import myBlog.repository.BlogRepository;
import myBlog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable){
        return blogRepository.findAll(pageable);
    }
    @Override
    public Blog findbyId(Long id){
        return blogRepository.findOne(id);
    }
    @Override
    public void save(Blog blog){
        blogRepository.save(blog);
    }
    @Override
    public void remove(Long id){
        blogRepository.delete(id);
    }
    @Override
    public Iterable<Blog> findAllByCategory(Category category){
        return blogRepository.findAllByCategory(category);
    }
    @Override
    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable){
        return blogRepository.findAllByTitleContaining(title, pageable);
    }
}
