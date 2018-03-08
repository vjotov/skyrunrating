package com.jotov.skyrunrating.controller;

import com.jotov.skyrunrating.dto.CompetitionDTO;
import com.jotov.skyrunrating.entity.Competition;
import com.jotov.skyrunrating.service.CompetitionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/competitions")
public class CompetitionRestController {
    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     *
     * @return List of all competitions in the system
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<CompetitionDTO> getAllCompetitions() {
        List<Competition> competitions = competitionService.getAllCompetitions();
        return competitions.stream()
                .map(competition -> convertToDto(competition))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param id id of the competition
     * @return competition data
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CompetitionDTO getCompetition(@PathVariable long id) {
        return new CompetitionDTO(competitionService.getCompetition(id));
    }


    /**
     *
     * @param competitionDto
     * @return the ID of the created competition
     */
    @RequestMapping(method = RequestMethod.POST)
    public long createCompetition(@RequestBody  CompetitionDTO competitionDto) {

        Competition competition = competitionService.createCompetition(competitionDto);
        return competition.getId();
    }

    private CompetitionDTO convertToDto(Competition competition) {
        CompetitionDTO competitionDTO = modelMapper.map(competition, CompetitionDTO.class);
        return competitionDTO;
    }
}
