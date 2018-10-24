package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/money")
public class Convert {
    @GetMapping
    public ModelAndView getCurrency(){
        ModelAndView modelGet = new ModelAndView("getCurrency");
        return modelGet;
    }
    @PostMapping
    public ModelAndView convertCurrency(@RequestParam("currency") double amount ){
        ModelAndView modelConvert = new ModelAndView("convertCurrency");
        double result = amount * 23000.0;
        modelConvert.addObject("result", result);
        return modelConvert;
    }
}

