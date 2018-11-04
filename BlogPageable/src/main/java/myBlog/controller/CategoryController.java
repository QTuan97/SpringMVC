package myBlog.controller;

import myBlog.model.Blog;
import myBlog.model.Category;
import myBlog.service.BlogService;
import myBlog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/categories")
    public ModelAndView listCategory(){
        Iterable<Category> categories = categoryService.findAll();
        ModelAndView list = new ModelAndView("/category/list");
        list.addObject("categories", categories);
        return list;
    }
    @GetMapping("/create-category")
    public ModelAndView showCreateCategory(){
        ModelAndView create = new ModelAndView("/category/create");
        create.addObject("category", new Category());
        return create;
    }
    @PostMapping("/create-category")
    public ModelAndView saveNewCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);

        ModelAndView save = new ModelAndView("/category/create");
        save.addObject("category", new Category());
        save.addObject("message", "New category created successfully!");
        return save;
    }
    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditCategory(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if(category != null){
            ModelAndView edit = new ModelAndView("/category/edit");
            edit.addObject("category", category);
            return edit;
        }
        else{
            ModelAndView showError = new ModelAndView();
            return showError;
        }
    }
    @PostMapping("/edit-category")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);

        ModelAndView update = new ModelAndView("/category/edit");
        update.addObject("category", category);
        update.addObject("message", "Updated successfully!");
        return update;
    }
    @GetMapping("/delete-category/{id}")
    public ModelAndView showDeleteCategory(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if(category != null){
            ModelAndView delete = new ModelAndView("/category/delete");
            delete.addObject("category", category);
            return delete;
        }else{
            ModelAndView showError = new ModelAndView();
            return showError;
        }
    }
    @PostMapping("/delete-category")
    public String deleteCategory(@ModelAttribute("category") Category category){
        categoryService.remove(category.getId());
        return "redirect:categories";
    }
    @GetMapping("/view-category/{id}")
    public ModelAndView viewCategory(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if(category == null){
            return new ModelAndView();
        }

        Iterable<Blog> blogs = blogService.findAllByCategory(category);
        ModelAndView viewBlog = new ModelAndView("/category/view");
        viewBlog.addObject("category", category);
        viewBlog.addObject("blog", blogs);
        return viewBlog;
    }
}
