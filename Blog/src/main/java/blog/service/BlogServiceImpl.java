package blog.service;

import blog.model.Blog;
import blog.repository.BlogRepository;
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
    public Blog findbyId(Long id){
        return blogRepository.findById(id);
    }
    @Override
    public void save(Blog blog){
        blogRepository.save(blog);
    }
    @Override
    public void remove(Long id){
        blogRepository.remove(id);
    }
}
