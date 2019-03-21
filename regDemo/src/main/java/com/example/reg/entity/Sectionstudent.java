package com.example.reg.entity;

import javax.persistence.*;

@Entity
@Table(name = "sectionstudent")
public class Sectionstudent {
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="iDCard")
	private Student stusec = new Student();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="sectionId")
	private Section secstu = new Section();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="iDCard")
	private Professor professor = new Professor();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "sectionstudentId")
	private int sectionstudentId;
	
	public Sectionstudent() {
		super();
	}
	
	public Sectionstudent(int sectionstudentId) {
		super();
		this.sectionstudentId = sectionstudentId;
	}

	public int getSectionStudentId() {
		return sectionstudentId;
	}

	public void setSectionStudentId(int sectionstudentId) {
		this.sectionstudentId = sectionstudentId;
	}

	public Student getStusec() {
		return stusec;
	}

	public void setStusec(Student stusec) {
		this.stusec = stusec;
	}

	public Section getSecstu() {
		return secstu;
	}

	public void setSecstu(Section secstu) {
		this.secstu = secstu;
	}

	public int getSectionstudentId() {
		return sectionstudentId;
	}

	public void setSectionstudentId(int sectionstudentId) {
		this.sectionstudentId = sectionstudentId;
	}

	public Professor getProfessor() {
		return professor;
	}

	
}
