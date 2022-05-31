package com.qa.F1.database.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.F1.database.Repo.*;




import com.qa.F1.database.Entity.*;


@Service
public class F1DatabaseService {


	private F1Repo repo;
	
	public F1DatabaseService(F1Repo repo) {
		this.repo = repo;
	}
	

	// Create
		public Champion create(Champion champion) {
			return repo.saveAndFlush(champion);
		}
		
		// ReadAll
		public List<Champion> getAll() {
			return repo.findAll();
		}
		
		// Read By ID
		public Champion getById(long id) {
			return repo.findById(id).get();
		}
		public List<Champion> getByYear(int year) {
			return repo.findByYear(year);
		}
		public List<Champion> getByName(String name) {
			return repo.findByName(name);
		}
		public List<Champion> getByNation(String nation) {
			return repo.findByNation(nation);
		}
		public List<Champion> getByTeam(String team) {
			return repo.findByTeam(team);
		}
		
		// Update
		public Champion update(long id, Champion champion) {
			// First, get the existing entry
			Champion existing = repo.findById(id).get();
			
			// Then, updated the existing entry using the new object
			existing.setYear(champion.getYear());
			existing.setName(champion.getName());
			existing.setNation(champion.getNation());
			existing.setTeam(champion.getTeam());
			
			return repo.saveAndFlush(existing);
		}

		// Delete
		public boolean delete(long id) {
			repo.deleteById(id);
			return !repo.existsById(id);
		}	
}
