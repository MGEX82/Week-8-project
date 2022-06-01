package com.qa.F1.database.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.F1.database.Entity.Champion;


@Repository
public interface F1Repo extends JpaRepository<Champion, Long> {
	List<Champion> findBySeason(int season);
	List<Champion> findByWinner(String winner);
	List<Champion> findByNation(String nation);
	List<Champion> findByTeam(String team);

}
