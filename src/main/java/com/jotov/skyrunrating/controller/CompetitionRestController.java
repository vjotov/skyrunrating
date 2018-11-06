package com.jotov.skyrunrating.controller;

import com.jotov.skyrunrating.dto.CompetitionDTO;
import com.jotov.skyrunrating.dto.context.Existing;
import com.jotov.skyrunrating.dto.context.New;
import com.jotov.skyrunrating.entity.Competition;
import com.jotov.skyrunrating.service.CompetitionService;
import com.jotov.skyrunrating.util.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        Competition competition = competitionService.getCompetition(id);
        if (competition==null)
            //return null;

            throw (new NotFoundException("Competition not found"));
        else
            return convertToDto(competition);
    }


    /**
     *
     * @param competitionDto
     * @return the ID of the created competition
     */
    @RequestMapping(method = RequestMethod.POST)
    public long createCompetition(@Validated(New.class) @RequestBody  CompetitionDTO competitionDto) {

        Competition competition = convertToEntity(competitionDto);
        competitionService.createCompetition(competition);
        return competition.getId();
    }

    /**
     *
     * @param competitionDto
     * @return the ID of the competition
     */
    @RequestMapping(method = RequestMethod.PUT )
    public long updateCompetition(@Validated(Existing.class) @RequestBody  CompetitionDTO competitionDto) {
        Competition competition = convertToEntity(competitionDto);
        competitionService.updateCompetition(competition);
        return competition.getId();
    }

    private Competition convertToEntity(CompetitionDTO competitionDto) {
        Competition competition = modelMapper.map(competitionDto, Competition.class);;
        return competition;
    }

    private CompetitionDTO convertToDto(Competition competition) {
        try {
            CompetitionDTO competitionDTO = modelMapper.map(competition, CompetitionDTO.class);
            return competitionDTO;
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }
}
