package com.example.reg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SubjectGrade")
public class SubjectGrade {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="iDCardStu")
	private Subject subjectGrade = new Subject();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="sectionId")
	private Grade GadeSubject = new Grade();
	
	@Id
	@Column(name = "IdSubjectGrade")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int IdSubjectGrade;

	public SubjectGrade() {
		super();
	}

	public SubjectGrade(int idSubjectGrade) {
		super();
		IdSubjectGrade = idSubjectGrade;
	}

	public Subject getSubjectGrade() {
		return subjectGrade;
	}

	public void setSubjectGrade(Subject subjectGrade) {
		this.subjectGrade = subjectGrade;
	}

	public Grade getGadeSubject() {
		return GadeSubject;
	}

	public int getIdSubjectGrade() {
		return IdSubjectGrade;
	}

	public void setIdSubjectGrade(int idSubjectGrade) {
		IdSubjectGrade = idSubjectGrade;
	}
	
	
}
