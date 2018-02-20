package com.jotov.skyrunrating;

import com.jotov.skyrunrating.service.CompetitionService;
import com.jotov.skyrunrating.repository.CompetiotionRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CompetitionServiceTest {
    private CompetitionService competitionService;
    private CompetiotionRepository competitionRepositoryMock;

    @Before
    public void setUp(){
        competitionService = new  CompetitionService();

        competitionRepositoryMock = mock(CompetiotionRepository.class);
        competitionService.setCompetiotionRepository(competitionRepositoryMock);
    }

    // to read: https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-three-custom-queries-with-query-methods/
//    @Test
//    public void
//
//    private SearchDTO createSearchDTO(String searchTerm, SearchType searchType) {
//
//    }
}

