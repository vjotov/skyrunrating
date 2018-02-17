package com.jotov.skyrunrating.controller;

import com.jotov.skyrunrating.entity.Competition;
import com.jotov.skyrunrating.model.CompetitionImportModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    //@RequestMapping(value = "/uploadfile", method =RequestMethod.GET)
    public ModelAndView showUploadForm(ModelAndView modelAndView) {
        modelAndView.setViewName("uploadForm");
        return modelAndView;
    }

    //@RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    public String uploadFile(
            ModelMap model,
            @RequestParam MultipartFile file,
            HttpServletRequest request) throws IOException {

        //TODO to remove import
        //TODO to transform the MultipartFile to File
        File fl = new File("123.csv");
        file.transferTo(fl);
        //CSVReader reader = new CSVReader(new FileReader(fl));
        //  List<CompetitionImportModel> beans =
        //          .withType(CompetitionImportModel.class).build().parse();
        return "uploadForm";
    }

    @GetMapping("/hello")
    public ModelAndView Hello() {
        //model.addAttribute("name", "Peter");
        //httpSession.setAttribute("name", "peter 2");
        //        Competition competition = new Competition(Long5,
        //      "123", new Date(), 12,13,
        //    100,12);

        ModelAndView mav = new ModelAndView("test");
        //mav.addObject("user", competition);
        //  mav.addObject("user",competition);
        //RedirectView rv = new RedirectView("/pesho");
        //mav.setView(rv);
        return mav;
    }

    //@GetMapping("/")
    public ModelAndView home() {
        //TODO - load data for home screen
        return new ModelAndView("base-layout");
    }

}
