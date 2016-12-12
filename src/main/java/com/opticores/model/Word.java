package com.opticores.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A simple model class mapping to 'words' table inside database and telling
 * hibernate that value for the primary key will be assigned the calling program
 * 
 * This class has been written just to simulate unit tests for the desired results.
 * 
 * @author anubhav
 *
 */
@Entity
@Table(name="words")
public class Word {
	
	@Id
	private Integer id;

	@Column
	private String word;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
