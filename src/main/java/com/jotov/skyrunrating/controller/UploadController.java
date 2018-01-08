package com.jotov.skyrunrating.controller;

import com.jotov.skyrunrating.competition.CompetitionService;
import com.jotov.skyrunrating.model.CompetitionImportModel;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
    public String singleFileUpload(
            @RequestParam("competitionFile")MultipartFile competitionFile,
            //@RequestParam("resultFile")MultipartFile resultFile,
            RedirectAttributes redirectAttributes
            ) {
        //https://stackoverflow.com/questions/28268499/understanding-multipartfile-transferto-method-in-spring-mvc

        if(competitionFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        competitionService.validateImport(competitionFile);

        return "redirect:uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public ModelAndView uploadStatus(ModelAndView modelAndView) {
        modelAndView.setViewName("uploadStatus");
        return modelAndView;
    }

}
