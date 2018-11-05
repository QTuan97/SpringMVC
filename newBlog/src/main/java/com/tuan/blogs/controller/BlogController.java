package com.tuan.blogs.controller;

import com.tuan.blogs.model.Blog;
import com.tuan.blogs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.SQLOutput;
import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    //Find all blogs
    @RequestMapping(value = "/blogs", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> listAllBlog(){
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }

    //Find single blog
    @RequestMapping(value = "/blogs/{id}", method = RequestMethod.GET, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getBlog(@PathVariable("id") long id){
        System.out.println("Fetching Blog with id: " + id);
        Blog blog = blogService.findById(id);
        if(blog == null){
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

    //Create new blog
    @RequestMapping(value = "/blogs", method = RequestMethod.POST)
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog, UriComponentsBuilder ucBuilder){
        System.out.println("Create a new blog" + blog.getTitle());
        blogService.save(blog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/blogs/{id}").buildAndExpand(blog.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //Edit blog
    @RequestMapping(value = "/blogs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Blog> editBlog(@PathVariable("id") long id, @RequestBody Blog blog){
        System.out.println("Edit blog " + id);
        Blog currentBlog = blogService.findById(id);
        if(currentBlog == null){
            System.out.println("Not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }else{
            currentBlog.setAuthor_name(blog.getAuthor_name());
            currentBlog.setTitle(blog.getTitle());
            currentBlog.setContent(blog.getContent());

            blogService.save(currentBlog);
            return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
        }
    }

    //Delete blog
    @RequestMapping(value = "/blogs/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") long id){
        System.out.println("Delete blog " + id);
        Blog blog = blogService.findById(id);
        if(blog == null){
            System.out.println("Not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }else{
            blogService.remove(id);
            return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
        }
    }
}
