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
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.F1.database.Entity.Champion;
import com.qa.F1.database.Service.F1DatabaseService;

@WebMvcTest

public class F1DatabaseControllerUnitTest {
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private F1DatabaseService service;
	
	@Test
	void createTest() throws Exception {
		Champion entry = new Champion(1950, "Nino Farina", "Italy", "Alfa Romeo");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Mockito.when(service.create(entry)).thenReturn(entry);
		
		mvc.perform(post("/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isCreated())
			.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void getAllTest() throws Exception {
		Champion entry = new Champion(1950, "Nino Farina", "Italy", "Alfa Romeo");
		List<Champion> output = new ArrayList<>();
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		Mockito.when(this.service.getAll()).thenReturn(output);
		
		mvc.perform(get("/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(outputAsJSON));
	}
	
	@Test
	public void getByIdTest() throws Exception {
		Champion entry = new Champion(1950, "Nino Farina", "Italy", "Alfa Romeo");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.getById(1L)).thenReturn(entry);
		
		mvc.perform(get("/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(entryAsJSON));
	}

	@Test
	public void getBySeasonTest() throws Exception {
		List<Champion> entries = new ArrayList<>();
		Champion entry = new Champion (1950, "Nino Farina", "Italy", "Alfa Romeo");
		entries.add(entry);
		String entriesAsJSON = mapper.writeValueAsString(entries);
		
		Mockito.when(this.service.getBySeason(1950)).thenReturn(entries);
		
		mvc.perform(get("/getBySeason/1950")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(entriesAsJSON));
	}
	
	@Test
	public void getByWinnerTest() throws Exception {
		List<Champion> entries = new ArrayList<>();
		Champion entry = new Champion (1950, "Nino Farina", "Italy", "Alfa Romeo");
		entries.add(entry);
		String entriesAsJSON = mapper.writeValueAsString(entries);
		
		Mockito.when(this.service.getByWinner("Nino Farina")).thenReturn(entries);
		
		mvc.perform(get("/getByWinner/Nino Farina")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(entriesAsJSON));
	}

	@Test
	public void getByNationTest() throws Exception {
		List<Champion> entries = new ArrayList<>();
		Champion entry = new Champion (1950, "Nino Farina", "Italy", "Alfa Romeo");
		entries.add(entry);
		String entriesAsJSON = mapper.writeValueAsString(entries);
		
		Mockito.when(this.service.getByNation("Italy")).thenReturn(entries);
		
		mvc.perform(get("/getByNation/Italy")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(entriesAsJSON));
	}
	
	@Test
	public void getByTeamTest() throws Exception {
		List<Champion> entries = new ArrayList<>();
		Champion entry = new Champion (1950, "Nino Farina", "Italy", "Alfa Romeo");
		entries.add(entry);
		String entriesAsJSON = mapper.writeValueAsString(entries);
		
		Mockito.when(this.service.getByTeam("Alfa Romeo")).thenReturn(entries);
		
		mvc.perform(get("/getByTeam/Alfa Romeo")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(entriesAsJSON));
	}
	@Test
	public void updateTest() throws Exception {
		Champion entry = new Champion(1950, "Nino Farina", "Italy", "Alfa Romeo");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.update(1L, entry)).thenReturn(entry);
		
		mvc.perform(put("/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception {
		Mockito.when(service.delete(1L)).thenReturn(true);
	
		mvc.perform(delete("/delete/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void deleteFailTest() throws Exception {
		Mockito.when(service.delete(3L)).thenReturn(false);
	
		mvc.perform(delete("/champion/delete/3")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
	}
}
