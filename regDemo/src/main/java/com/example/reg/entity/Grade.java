package com.example.reg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Grade")
public class Grade {

	@Id
	@Column(name = "IdGrade")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int IdGrade;
	
	@Column(name = "grade")
	private String grade;
	public Grade() {
		super();
	}
	public Grade(int idGrade, String grade) {
		super();
		IdGrade = idGrade;
		this.grade = grade;
	}
	public int getIdGrade() {
		return IdGrade;
	}
	public void setIdGrade(int idGrade) {
		IdGrade = idGrade;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
