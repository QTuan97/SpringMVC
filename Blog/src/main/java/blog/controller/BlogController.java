package blog.controller;

import blog.model.Blog;
import blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView showCreateForm = new ModelAndView("/blog/create");
        showCreateForm.addObject("blog", new Blog());
        return showCreateForm;
    }
    @PostMapping("/create")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView save = new ModelAndView("/blog/create");
        save.addObject("blog", new Blog());
        save.addObject("mess","Successfully!");
        return save;
    }
    @GetMapping("/blogs")
    public ModelAndView BlogList(){
        List<Blog> blogs = blogService.findAll();
        ModelAndView list = new ModelAndView("/blog/list");
        list.addObject("blog", blogs);
        return list;

    }
    @GetMapping("/view-blog/{id}")
    public ModelAndView viewBlog(@PathVariable Long id){
        Blog blog = blogService.findbyId(id);
        if(blog != null){
            ModelAndView viewBlog = new ModelAndView("/blog/view");
            viewBlog.addObject("blog", blog);
            return viewBlog;
        }else{
            ModelAndView error = new ModelAndView("/error-404");
            return error;
        }
    }
    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEdit(@PathVariable Long id){
        Blog blog = blogService.findbyId(id);
        if(blog != null){
            ModelAndView editForm = new ModelAndView("/blog/edit");
            editForm.addObject("blog", blog);
            return editForm;
        }
        else{
            ModelAndView error = new ModelAndView("/error-404");
            return error;
        }
    }
    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView save = new ModelAndView("/blog/edit");
        save.addObject("blog",blog);
        save.addObject("mess","Successfully!");
        return save;
    }
    @GetMapping("/delete-blog/{id}")
    public ModelAndView deleteBlog(@PathVariable Long id){
        Blog blog = blogService.findbyId(id);
        if(blog != null){
            ModelAndView delete = new ModelAndView("/blog/delete");
            delete.addObject("blog", blog);
            return delete;
        }else{
            ModelAndView error = new ModelAndView("/error-404");
            return error;
        }
    }
    @PostMapping("/delete-blog")
    public String delete(@ModelAttribute("blog") Blog blog){
        blogService.remove(blog.getId());
        return "redirect:blogs";
    }
}
