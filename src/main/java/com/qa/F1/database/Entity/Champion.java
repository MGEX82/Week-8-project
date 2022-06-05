package com.qa.F1.database.Entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Champion  {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private int season;

    @Column (nullable = false)
    private String winner;

    @Column
    private String nation;

    @Column
    private String team;

 

    // Default constructor
    
   

    public Champion(int season, String winner, String nation, String team ) {
        super();
        this.season = season;
        this.winner = winner;
        this.nation = nation;
        this.team = team;
        
        
    }



	

}
