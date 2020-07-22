package com.truelayer.pokemon;

import com.truelayer.pokemon.beans.PokemonShakespeare;
import com.truelayer.pokemon.exception.ExceptionDetails;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PokemonShakespeareDescriptionApplicationTests {

	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate testRestTemplate;
	@Test
	public void testValidPokemonShakespeareDescription() {
		String name = "charizard";
		PokemonShakespeare response = testRestTemplate.getForObject(
				getURLWithPort(), PokemonShakespeare.class,name);
		Assert.assertEquals("Spits fire yond is hot enow to melt boulders. Known to cause forest fires unintentionally.",response.getDescription());
		Assert.assertTrue(name.equalsIgnoreCase(response.getName()));
	}

	@Test
	public void testInValidPokemonRequestForShakespeareDescription() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<ExceptionDetails> response = testRestTemplate.exchange(getURLWithPort(),HttpMethod.GET,entity,ExceptionDetails.class,"123");
		ExceptionDetails exceptionDetails = response.getBody();
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		Assert.assertEquals("uri=/pokemon/123", exceptionDetails.getDetails());
	}
	private String getURLWithPort() {
		return "http://localhost:" + port+"/pokemon/{name}";
	}

}
