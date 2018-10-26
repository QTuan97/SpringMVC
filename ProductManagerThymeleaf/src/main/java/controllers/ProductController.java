package controllers;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping
    public ModelAndView showIndex(){
        ModelAndView modelAndView = new ModelAndView("index","products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/products/create")
    public String create(Model model){
        model.addAttribute("products", new Product());
        return "create";
    }

    @PostMapping("/products/save")
    public String save(Product product, RedirectAttributes redirect){
        product.setId((int)(Math.random()*10000));
        productService.save(product);
        redirect.addFlashAttribute("success","Saved product successfully!");
        return  "redirect:/";
    }

    @GetMapping("/products/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("products", productService.findById(id));
        return "edit";
    }

    @PostMapping("/products/update")
    public String udpate(Product product, RedirectAttributes redirect){
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Update successfully");
        return "redirect:/";
    }

    @GetMapping("/products/{id}/delete")
    public String delete (Product product, RedirectAttributes redirect){
        productService.remove(product.getId());
        redirect.addFlashAttribute("success","Delete successfully");
        return "redirect:/";
    }


    @GetMapping("/products/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("products", productService.findAll());
        return "view";
    }
}
