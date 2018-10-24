package controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/dictionary")
public class Dictionary {
    @GetMapping
    public ModelAndView getWord(){
        ModelAndView getWord = new ModelAndView("getWord");
        return getWord;
    }

    @PostMapping
    public ModelAndView wordMeaning(@RequestParam("getWord") String word){
        ModelAndView wordMeaning = new ModelAndView("wordMeaning");
        HashMap<String,String> wordDictionary = new HashMap();
        wordDictionary.put("book","cuốn sách");
        wordDictionary.put("car","xe ô tô");
        wordDictionary.put("cat","mèo");
        wordDictionary.put("dog","chó");
        wordMeaning.addObject("yourWord", word);
        for(String i : wordDictionary.keySet()){
            if(i.equals(word)){
                String result = wordDictionary.get(i);
                wordMeaning.addObject("result", result);
                return wordMeaning;
            }else{
                wordMeaning.addObject("result", "No meaning");
            }
        }
        return wordMeaning;
    }
}
