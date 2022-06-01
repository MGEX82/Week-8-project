package com.qa.F1.database.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.qa.F1.database.Entity.*;
import com.qa.F1.database.Service.*;

@RestController
public class F1DatabaseController {
private F1DatabaseService service;
	
	
	public F1DatabaseController(F1DatabaseService service) {
		this.service = service;
	}
	
	// Read -> Get Request -@GetMapping
	// Read ALL
	@GetMapping("/getAll")
	public ResponseEntity <List<Champion>> getAll() {
		return new ResponseEntity<List<Champion>> (this.service.getAll(), HttpStatus.OK);
		
	}
	
	// Read By ID
	@GetMapping("/getById/{id}")
	public ResponseEntity<Champion> getById(@PathVariable long id) {
		return new ResponseEntity<Champion>(service.getById(id), HttpStatus.OK);
	}
	@GetMapping("/getBySeason/{season}")
	public ResponseEntity<List<Champion>> getByYear(@PathVariable int season) {
		return new ResponseEntity<List<Champion>>(service.getBySeason(season), HttpStatus.OK);
	}
	@GetMapping("/getByWinner/{winner}")
	public ResponseEntity<List<Champion>> getByWinner(@PathVariable String winner) {
		return new ResponseEntity<List<Champion>>(service.getByWinner(winner), HttpStatus.OK);
	}
	@GetMapping("/getByNation/{nation}")
	public ResponseEntity<List<Champion>> getByNation(@PathVariable String nation) {
		return new ResponseEntity<List<Champion>>(service.getByNation(nation), HttpStatus.OK);
	}
	@GetMapping("/getByTeam/{team}")
	public ResponseEntity<List<Champion>> getByTeam(@PathVariable String team) {
		return new ResponseEntity<List<Champion>>(service.getByTeam(team), HttpStatus.OK);
	}
	
	
	
	// Create -> Post Request - @PostMapping
	@PostMapping("/create")
	public ResponseEntity<Champion> create(@RequestBody Champion champion) {
		return new ResponseEntity<Champion>(service.create(champion), HttpStatus.CREATED);
	}
	
	// Update -> Put/Patch Request - @PutMapping
	@PutMapping("/update/{id}")
	public ResponseEntity<Champion> update(@PathVariable long id, @RequestBody Champion champion) {
		return new ResponseEntity<Champion>(service.update(id, champion), HttpStatus.ACCEPTED);
	}

//	 Delete -> Delete Request - @DeleteMapping
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.NO_CONTENT);
	}

}
