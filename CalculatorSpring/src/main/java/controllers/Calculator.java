package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class Calculator {
    @GetMapping
    public ModelAndView Math(){
        ModelAndView getNumber = new ModelAndView("index");
        return getNumber;
    }
    @PostMapping
    public ModelAndView Calculator(@RequestParam("frist") double frist, @RequestParam("second") double second,
    @RequestParam("operation") String operation){
        ModelAndView calculator = new ModelAndView("index");
        if(operation.equals("Addition(+)")){
            double result = frist + second;
            calculator.addObject("say","Result addition:");
            calculator.addObject("result", result);
            return calculator;
        }else if(operation.equals("Subtraction(-)")){
            double result = frist - second;
            calculator.addObject("say","Result subtraction:");
            calculator.addObject("result",result);
            return calculator;
        }else if(operation.equals("Multiplication(*)")){
            double result = frist * second;
            calculator.addObject("say", "Result multipilcation:");
            calculator.addObject("result", result);
            return calculator;
        }else if(operation.equals("Division(/)")){
            if(second == 0){
                calculator.addObject("say","Result division:");
                calculator.addObject("result","Can't div 0");
                return calculator;
            }else{
                double result = frist/second;
                calculator.addObject("say", "Result division");
                calculator.addObject("result",result);
                return  calculator;
            }
        }else {
            return calculator;
        }
    }
}
