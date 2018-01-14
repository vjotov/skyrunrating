package com.jotov.skyrunrating.controller;

import com.jotov.skyrunrating.competition.CompetitionService;
import com.jotov.skyrunrating.model.CompetitionImportModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UploadController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping("/upload")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("uploadForm");
        return modelAndView;
    }

    @PostMapping("/upload")
    public ModelAndView singleFileUpload(
            @RequestParam("competitionFile")MultipartFile competitionFile
            ) {
        //TODO: to extract messages in resource file

        //https://stackoverflow.com/questions/28268499/understanding-multipartfile-transferto-method-in-spring-mvc

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("uploadStatus");
        if(competitionFile.isEmpty()) {
            modelAndView.addObject("message", "Please select a file to upload");
            return modelAndView;
        }
        CompetitionImportModel ciModel = competitionService.validateImport(competitionFile);
        modelAndView.addObject("message", "File is successfully validated. Please overview the data in it");
        modelAndView.addObject("ciModel",ciModel);
        return modelAndView;
    }

    @GetMapping("/uploadStatus")
    public ModelAndView uploadStatus(ModelAndView modelAndView) {
        modelAndView.setViewName("uploadStatus");
        return modelAndView;
    }

}
