package com.example.reg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Professor")
public class Professor {
	
	@Id
	@Column(name = "iDCard")
	private String iDCard;
	/*@GeneratedValue(strategy=GenerationType.AUTO)*/
	@Column(name = "fname")
	private String fname;
	
	@Column(name = "lname")
	private String lname;
	
	@Column(name = "passWord")
	private String passWord;
	
	@Column(name = "tel")
	private String tel;
	
	public Professor(String fname, String lname, String passWord, String iDCard, String tel) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.passWord = passWord;
		this.iDCard = iDCard;
		this.tel = tel;
	}
	public Professor() {
		super();
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
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
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
	
	
}
