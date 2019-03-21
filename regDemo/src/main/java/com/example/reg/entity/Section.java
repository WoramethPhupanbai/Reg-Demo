package com.example.reg.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Section")
public class Section {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "sectionId")
	private int sectionId;
	
	@Column(name = "sectionName")
	private String sectionName;

	@Transient
	private ArrayList<Section> listSection = new ArrayList<Section>();
	
	public Section(int sectionId, String sectionName) {
		super();
		this.sectionId = sectionId;
		this.sectionName = sectionName;
	}

	public Section() {
		super();
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public ArrayList<Section> getListSection() {
		return listSection;
	}
	
	
}
