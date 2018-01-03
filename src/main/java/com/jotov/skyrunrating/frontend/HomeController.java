package com.jotov.skyrunrating.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @RequestMapping(value = "/uploadfile", method =RequestMethod.GET)
    public ModelAndView showUploadForm(ModelAndView modelAndView) {
        modelAndView.setViewName("uploadForm.html");
        return modelAndView;
    }

    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    public String uploadFile(
            ModelMap model,
            @RequestParam MultipartFile file,
            HttpServletRequest request) {
        return "uploadForm";
    }
}
