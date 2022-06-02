package com.qa.F1.database.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.F1.database.Entity.Champion;
import com.qa.F1.database.Repo.F1Repo;
import com.qa.F1.database.Service.F1DatabaseService;


@SpringBootTest(classes=com.qa.F1.database.Service.F1DatabaseService.class)

public class F1DatabaseServiceTest {
	@Autowired
	private F1DatabaseService service;

	@MockBean
	private F1Repo repo;

	// Create Test
	@Disabled
	@Test
	public void createTest() {
		Champion incoming =new Champion (1950, "Nino Farina", "Italy", "Alfa Romeo");
		Champion expected =new Champion (1L, 1950, "Nino Farina", "Italy", "Alfa Romeo");
	}

	

	// ReadAll Test
	@Test
	public void getAllTest() {
		// Creating any expected output and inputs if necessary
		List<Champion> output = new ArrayList<>();
		output.add(new Champion(1L, 1950, "Nino Farina", "Italy", "Alfa Romeo"));
		
		// Mocking the dependency (repo)
		Mockito.when(repo.findAll()).thenReturn(output);
		
		// Asserting the actual test method's output
		assertEquals(output, service.getAll());
		
		// Verifying the number of times a mock method ran - Not Required
		Mockito.verify(repo, Mockito.times(1)).findAll(); 
	}

	// Read By ID Test
	@Disabled
	@Test
	public void getByIdTest(long id) {
		Champion output = new Champion(1L, 1950, "Nino Farina", "Italy", "Alfa Romeo");
		Optional<Champion> optionalOutput = Optional.of(output);
		Mockito.when(repo.findById(1L)).thenReturn(optionalOutput);
		
		
	}

	

	// Read By FirstName Test
	@Disabled
	@Test
	public void getBySeasonTest(int season) {
		List<Champion> output = new ArrayList<>();
		output.add(new Champion(1L, 1950, "Nino Farina", "Italy", "Alfa Romeo"));
		Mockito.when(repo.findBySeason(1950)).thenReturn(output);
		assertEquals(output, service.getBySeason(1950));
		
		
		
		
	}
	public void getByWinnerTest(String winner) {
		List<Champion> output = new ArrayList<>();
		output.add(new Champion(1L, 1950, "Nino Farina", "Italy", "Alfa Romeo"));
		Mockito.when(repo.findByWinner("Nino Farina")).thenReturn(output);
		assertEquals(output, service.getByWinner("Nino Farina"));
		
		
		
		
	}
	public void getByNationTest(String nation) {
		List<Champion> output = new ArrayList<>();
		output.add(new Champion(1L, 1950, "Nino Farina", "Italy", "Alfa Romeo"));
		Mockito.when(repo.findByNation("Italy")).thenReturn(output);
		assertEquals(output, service.getByNation("Italy"));
		
		
		
		
	}
	public void getByTeamTest(String team) {
		List<Champion> output = new ArrayList<>();
		output.add(new Champion(1L, 1950, "Nino Farina", "Italy", "Alfa Romeo"));
		Mockito.when(repo.findByTeam("Alfa Romeo")).thenReturn(output);
		assertEquals(output, service.getByTeam("Alfa Romeo"));
		
		
		
		
	}


	

	// Update Test
	@Disabled
	@Test
	public void updateTest() {
		Champion input = new Champion(1950, "Nino Farina", "Italy", "Alfa Romeo");
		Optional<Champion> existing = Optional.of(new Champion(1L, 1950, "Juan Manuel Fangio", "Argentina", "Alfa Romeo" ));
		Champion output = new Champion(1L, 1950, "Nino Farina", "Italy", "Alfa Romeo");
		
		// Mocking the dependency (repo)
		Mockito.when(repo.findById(1L)).thenReturn(existing);
		Mockito.when(repo.saveAndFlush(output)).thenReturn(output);
		
		// Asserting the actual test method's output
		assertEquals(output, service.update(1L, input));
		
		// Verifying the number of times a mock method ran - Not Required
		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(output);
		Mockito.verify(repo, Mockito.times(1)).findById(1L);
	}
		
	
	
	// Delete Test
	@Disabled
	@Test
	public boolean deleteTest() {
		repo.deleteById(1L);
		return !repo.existsById(1L);
		
	}
}

