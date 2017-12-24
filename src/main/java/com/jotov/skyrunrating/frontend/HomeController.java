package com.jotov.skyrunrating.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String rootPage(Model model) {
        model.addAttribute("name","this is my name");
        return "viewHome";
    }
    @RequestMapping(value = "/uploadfile", method =RequestMethod.GET)
    public String showUploadForm() {
        return "uploadForm.jsp";
    }

    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    public String uploadFile(
            ModelMap model,
            @RequestParam MultipartFile file,
            HttpServletRequest request) {
        return "uploadForm";
    }
}
