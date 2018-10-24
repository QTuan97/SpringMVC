package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class index {
    @GetMapping
    public ModelAndView getCurrency(){
        ModelAndView modelGet = new ModelAndView("index");
        return modelGet;
    }
}

