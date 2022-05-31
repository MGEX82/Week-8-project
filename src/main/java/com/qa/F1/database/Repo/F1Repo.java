package com.qa.F1.database.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.F1.database.Entity.Champion;


@Repository
public interface F1Repo extends JpaRepository<Champion, Long> {
	List<Champion> findByYear(int year);
	List<Champion> findByName(String name);
	List<Champion> findByNation(String nation);
	List<Champion> findByTeam(String team);

}
