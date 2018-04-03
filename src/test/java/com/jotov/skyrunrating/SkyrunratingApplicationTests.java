package com.jotov.skyrunrating;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Import(TestsConfiguration.class)
@SpringBootTest
public class SkyrunratingApplicationTests {

	//@Autowired
	private TestRestTemplate restTemplate = new TestRestTemplate();

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
			MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

//	@Test
//	public void contextLoads() {
//	}

	@Test
	public void emptyCompetitionListTest() {
		String body = this.restTemplate.getForObject("http://localhost:8090/competitions", String.class);
		assertThat(body).isEqualTo("[]");
	}

	@Test
	public void createCompetitionTest() {
		String reqyestBody = "{\n" +
				"  \"name\":\"Marathon\",\n" +
				"  \"description\":\"10.10.2010\",\n" +
				"    \"maxPoints\":\"100\",\n" +
				"    \"meterDistance\":\"42195\",\n" +
				"    \"meterDisplacement\":\"5\",\n" +
				"    \"secondsRecord\":\"7500\"\n" +
				"}";
		RequestEntity request = null;
		try {
			request = RequestEntity.post(new URI("http://localhost:8090/competitions")).accept(MediaType.APPLICATION_JSON).body(reqyestBody);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<String> body = this.restTemplate.exchange(request, String.class);
		//String body = this.restTemplate.getForObject("http://localhost:8090/competitions", String.class);
		assertThat(body.toString()).isEqualTo("1");

	}
	@Test
    public void exampleTest() {

    }
}
