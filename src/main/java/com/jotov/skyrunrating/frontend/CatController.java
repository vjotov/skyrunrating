package com.jotov.skyrunrating.frontend;

import com.jotov.skyrunrating.entity.Cat;
import com.jotov.skyrunrating.model.CatModel;
import com.jotov.skyrunrating.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/cat")
public class CatController {
    @Autowired
    private CatService catService;

    @GetMapping("/cat")
    public String getCatHomePage() {
        return "cat-home-page.html";
    }

//        @PostMapping("")
//        public String buyCat(@RequestParam String name, @RequestParam int age) {
//            System.out.println("Name: " + name);
//            System.out.println("Age: " + age);
//            return "redirect:/cat";
//        }
    @PostMapping("/cat")
    public String buyCat(@ModelAttribute CatModel cat){
            System.out.println("Name: " + cat.getName());
            System.out.println("Age: " + cat.getAge());
            this.catService.buy(cat); // запис в базата
            return "redirect:/cat";
    }

    @GetMapping("/cat/edit/{catId}")
    @ResponseBody
    public String getEdit(@PathVariable long catId) {
        return String.valueOf(catId);
    }

    @GetMapping("/my")
    //@ResponseBody
    public ModelAndView getCat(ModelAndView modelAndView, Model model) {
        String cat = "cat";
        model.addAttribute("cat", cat);
        modelAndView.addObject("cat", cat);
        modelAndView.setViewName("cats.html");
        return modelAndView;
    }
}
