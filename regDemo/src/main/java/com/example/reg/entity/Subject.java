package com.example.reg.entity;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "Subject")
public class Subject {

	@Id
	@Column(name = "subjectId")
	private String subjectId;
	
	@Column(name = "subjectName")
	private String subjectName;
	
	@Transient
	private ArrayList<ClassRoom> listClassRoom = new ArrayList<ClassRoom>();
	
	public Subject(String subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}
	public Subject() {
		super();
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public ArrayList<ClassRoom> getListClassRoom() {
		return listClassRoom;
	}
	
}
