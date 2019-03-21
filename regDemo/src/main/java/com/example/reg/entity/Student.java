package com.example.reg.entity;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@Column(name = "iDCard")
	private String iDCard;
	
	@Column(name = "stuId",unique=true )
	private String stuId;
	
	@Column(name = "passWord")
	private String passWord;
	
	@Column(name = "fname")
	private String fname;
	
	@Column(name = "lname")
	private String lname;
	
	@Column(name = "tel")
	private String tel;
	
	@Column(name = "email")
	private String email;
	
	@Transient
	private ArrayList<Student> listStudent = new ArrayList<Student>();
	public Student(String stuId, String passWord, String fname, String lname, String iDCard, String tel,String email) {
		super();
		this.stuId = stuId;
		this.passWord = passWord;
		this.fname = fname;
		this.lname = lname;
		this.iDCard = iDCard;
		this.tel = tel;
		this.email = email;
	}
	public Student() {
		super();
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getiDCard() {
		return iDCard;
	}
	public void setiDCard(String iDCard) {
		this.iDCard = iDCard;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Student> getListStudent() {
		return listStudent;
	}
	
}
