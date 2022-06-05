package com.qa.F1.database.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.F1.database.Entity.Champion;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class F1DatabaseControllerIntegrationTest {
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void createTest() throws Exception {
		Champion input = new Champion(1951, "Juan Manuel Fangio", "Argentina", "Alfa Romeo");
		String inputAsJSON = mapper.writeValueAsString(input);
		
		Champion output = new Champion(2L, 1951, "Juan Manuel Fangio", "Argentina", "Alfa Romeo");
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(post("/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(outputAsJSON)); 
		
	}
	
	@Test
	public void getAllTest() throws Exception {
		Champion champion = new Champion(1L, 1950, "Nino Farina", "Italy", "Alfa Romeo");
		List<Champion> output = new ArrayList<>();
		output.add(champion);
		
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(outputAsJSON));
	}
	
	@Test
	public void getByIdTest() throws Exception {
		Champion entry = new Champion(1L, 1950, "Nino Farina", "Italy", "Alfa Romeo");
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		mvc.perform(get("/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(entryAsJSON));
	}
	@Test
	public void getBySeasonTest() throws Exception {
		Champion champion = new Champion(1L, 1950, "Nino Farina", "Italy", "Alfa Romeo");
		List<Champion> output = new ArrayList<>();
		output.add(champion);
		
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/getBySeason/1950")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(outputAsJSON));
	}
	@Test
	public void getByWinnerTest() throws Exception {
		Champion champion = new Champion(1L, 1950, "Nino Farina", "Italy", "Alfa Romeo");
		List<Champion> output = new ArrayList<>();
		output.add(champion);
		
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/getByWinner/Nino Farina")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(outputAsJSON));
	}
	@Test
	public void getByNationTest() throws Exception {
		Champion champion = new Champion(1L, 1950, "Nino Farina", "Italy", "Alfa Romeo");
		List<Champion> output = new ArrayList<>();
		output.add(champion);
		
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/getByNation/Italy")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(outputAsJSON));
	}
	@Test
	public void getByTeamTest() throws Exception {
		Champion champion = new Champion(1L, 1950, "Nino Farina", "Italy", "Alfa Romeo");
		List<Champion> output = new ArrayList<>();
		output.add(champion);
		
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/getByTeam/Alfa Romeo")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(outputAsJSON));
	}
	
	
	
	@Test
	public void updateTest() throws Exception {
		Champion entry = new Champion(1950, "Nino Farina", "Italy", "Alfa Romeo");
		Champion result = new Champion(1L, 1950, "Nino Farina", "Italy", "Alfa Romeo");
		
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(put("/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/delete/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNoContent());
	}

}
