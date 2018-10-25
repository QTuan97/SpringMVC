package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class Sandwich {
    @GetMapping
    public ModelAndView getCondiment(){
        ModelAndView getThings = new ModelAndView("index");
        return getThings;
    }

    @PostMapping
    public ModelAndView yourSandwich(@RequestParam("condiment") String condiment) {
        ModelAndView addCondiments = new ModelAndView("index");
        ArrayList<String> condimentsList = new ArrayList<>();
        condimentsList.add(condiment);
        if(condimentsList.size() > 0){
            addCondiments.addObject("say", "You had added");
            for(String things : condimentsList){
                addCondiments.addObject("condiments",things);
            }
            return addCondiments;
        }else {
            return addCondiments;
        }

    }
}
