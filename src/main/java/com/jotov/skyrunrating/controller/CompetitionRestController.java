package com.jotov.skyrunrating.controller;

import com.jotov.skyrunrating.dto.CompetitionDTO;
import com.jotov.skyrunrating.entity.Competition;
import com.jotov.skyrunrating.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/competitions")
public class CompetitionRestController {
    @Autowired
    private CompetitionService competitionService;

    /**
     *
     * @return List of all competitions in the system
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<CompetitionDTO> getAllCompetitions() {
        List<CompetitionDTO> competitionsDTO = new ArrayList<> ();
        competitionService.getAllCompetitions()
                .forEach((competition) -> competitionsDTO.add(new CompetitionDTO(competition)));
        return competitionsDTO;
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
}
