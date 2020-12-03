package com.otrs.restaurant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.otrs.restaurant.domain.model.entity.Table;
import com.otrs.restaurant.resources.AbstractRestaurantControllerTests;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestaurantserviceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT, properties = {
		"management.server.port=0", "management.context-path=/admin" })
public class RestaurantserviceApplicationTests extends AbstractRestaurantControllerTests {

	// Required to generate JSON content from java objects
	public static final ObjectMapper ObjectMapper = new ObjectMapper();
	private final TestRestTemplate testRestTemplate = new TestRestTemplate();

	@LocalServerPort
	private int port;

	public RestaurantserviceApplicationTests() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testGetRestaurantById() {
		Map<String, Object> response = testRestTemplate.getForObject("http://localhost:" + port + "/v1/restaurants/1",
				Map.class);
		assertNotNull(response);

		String id = response.get("id").toString();
		assertNotNull(id);
		assertEquals("1", id);
		String name = response.get("name").toString();
		assertNotNull(name);
		assertEquals("Le Meurice", name);
		boolean isModified = (boolean) response.get("isModified");
		assertEquals(false, isModified);
		List<Table> tableList = (List<Table>) response.get("tables");
		assertNull(tableList);
	}

	/* Test the GET /v1/restaurants/{id} API for no content */
	@Test
	public void testGetById_NoContent() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		ResponseEntity<Map> responseE = testRestTemplate.exchange("http://localhost:" + port + "/v1/restaurants/99",
				HttpMethod.GET, entity, Map.class);
		assertNotNull(responseE);
		// Should return no content as there
		// is no restaurant with id 99
		assertEquals(HttpStatus.NO_CONTENT, responseE.getStatusCode());
	}

	@Test
	public void testGetByName() {
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<Object> entity = new HttpEntity<>(httpHeaders);
		Map<String, Object> urlVariables = new HashMap<>();
		urlVariables.put("name", "Meurice");
		ResponseEntity<Map[]> responseEntity = testRestTemplate.exchange(
				"http://localhost:" + port + "/v1/restaurants?name={name}", HttpMethod.GET, entity, Map[].class,
				urlVariables);
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());		
		Map[] responses = responseEntity.getBody();
		assertNotNull(responses);
		assertTrue(responses.length ==1);
		
		Map<String, Object> response = responses[0];
		
		//Asserting Id check
		String id = response.get("id").toString();
		assertNotNull(id);
		assertEquals("1", id);
		
		//Asserting Name check
		String name = response.get("name").toString();
		assertNotNull( name);
		assertEquals("Le Meurice", name);
		
		
		boolean isModified = (boolean) response.get("isModified");
	    assertEquals(false, isModified);
	    List<Table> tableList = (List<Table>) response.get("tables");
	    assertNull(tableList);
	}

}
