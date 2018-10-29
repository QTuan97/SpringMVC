package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ProductService;
import service.ProductServiceImpl;

@Controller
public class ProductController {
    private ProductService productService = new ProductServiceImpl();
    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView index = new ModelAndView("index");
        index.addObject("products", productService.findAll());
        return index;
    }
    @GetMapping("/product/create")
    public ModelAndView create(){
        ModelAndView create = new ModelAndView("create");
        create.addObject("products", new Product());
        return create;
    }
    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirect){
        product.setId((int)(Math.random()*100000));
        productService.save(product);
        redirect.addFlashAttribute("success", "Saved product successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        ModelAndView edit = new ModelAndView("edit");
        edit.addObject("products",productService.findById(id));
        return edit;
    }
    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect){
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("products", "Updated product successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView delete = new ModelAndView("delete");
        delete.addObject("products", productService.findById(id));
        return delete;
    }
    @PostMapping("/product/delete")
    public String delete(Product product, RedirectAttributes redirect){
        productService.remove(product.getId());
        redirect.addFlashAttribute("products", "Removed product successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/view")
    public ModelAndView view(@PathVariable int id){
        ModelAndView view = new ModelAndView("view");
        view.addObject("products", productService.findById(id));
        return view;
    }

}

