package com.qa.F1.database.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.F1.database.Repo.*;




import com.qa.F1.database.Entity.*;
import com.qa.F1.database.Exceptions.EntryNotFound;


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
			return repo.findById(id).orElseThrow(EntryNotFound::new);
		}
		public List<Champion> getBySeason(int season) {
			return repo.findBySeason(season);
		}
		public List<Champion> getByWinner(String winner) {
			return repo.findByWinner(winner);
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
			Champion existing = repo.findById(id).orElseThrow(EntryNotFound::new);
			
			// Then, updated the existing entry using the new object
			existing.setSeason(champion.getSeason());
			existing.setWinner(champion.getWinner());
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
