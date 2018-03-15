package com.jotov.skyrunrating;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Import(TestsConfiguration.class)
@SpringBootTest
public class SkyrunratingApplicationTests {

	//@Autowired
	private TestRestTemplate restTemplate = new TestRestTemplate();

//	@Test
//	public void contextLoads() {
//	}

	@Test
	public void emptyCompetitionListTest() {
		String body = this.restTemplate.getForObject("http://localhost:8090/competitions", String.class);
		assertThat(body).isEqualTo("[]");
	}

	@Test
    public void exampleTest() {

    }
}
