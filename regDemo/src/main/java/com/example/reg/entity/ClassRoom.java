package com.example.reg.entity;

import javax.persistence.*;

@Entity
@Table(name = "classRoom")
public class ClassRoom {
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="iDCardStu")
	private Student classRoomStudent = new Student();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="sectionId")
	private Section classRoomsection = new Section();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="subjectId")
	private Subject classRoomSubject = new Subject();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="iDCard")
	private Professor classRoomProfessor = new Professor();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "classRoomId")
	private int classRoomId;

	public ClassRoom(int classRoomId) {
		super();
		this.classRoomId = classRoomId;
	}

	public ClassRoom() {
		super();
	}

	public Student getClassRoomStudent() {
		return classRoomStudent;
	}

	public void setClassRoomStudent(Student classRoomStudent) {
		this.classRoomStudent = classRoomStudent;
	}

	public Section getClassRoomsection() {
		return classRoomsection;
	}

	public void setClassRoomsection(Section classRoomsection) {
		this.classRoomsection = classRoomsection;
	}

	public Subject getClassRoomSubject() {
		return classRoomSubject;
	}

	public void setClassRoomSubject(Subject classRoomSubject) {
		this.classRoomSubject = classRoomSubject;
	}

	public Professor getClassRoomProfessor() {
		return classRoomProfessor;
	}

	public void setClassRoomProfessor(Professor classRoomProfessor) {
		this.classRoomProfessor = classRoomProfessor;
	}

	public int getClassRoomId() {
		return classRoomId;
	}

	public void setClassRoomId(int classRoomId) {
		this.classRoomId = classRoomId;
	}
	

	
}
