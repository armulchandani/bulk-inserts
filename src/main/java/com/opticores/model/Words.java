package com.opticores.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A simple model class mapping to 'words' table inside database and telling
 * hibernate to assign the value for the primary key
 * 
 * @author anubhav
 *
 */
@Entity
@Table
public class Words {

	@Id
	@GeneratedValue
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
