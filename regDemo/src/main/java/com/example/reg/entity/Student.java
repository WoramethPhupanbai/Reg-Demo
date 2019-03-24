package com.example.reg.entity;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@Column(name = "iDCardStu")
	private String iDCardStu;
	
	@Column(name = "stuId",unique=true )
	private String stuId;
	
	@Column(name = "passWordStu")
	private String passWordStu;
	
	@Column(name = "fnameStu")
	private String fnameStu;
	
	@Column(name = "lnameStu")
	private String lnameStu;
	
	@Column(name = "telStu")
	private String telStu;
	
	@Column(name = "emailStu")
	private String emailStu;
	
	@Transient
	private ArrayList<ClassRoom> listClassRoom = new ArrayList<ClassRoom>();
	
	
	public Student(String iDCardStu, String stuId, String passWordStu, String fnameStu, String lnameStu, String telStu,
			String emailStu) {
		super();
		this.iDCardStu = iDCardStu;
		this.stuId = stuId;
		this.passWordStu = passWordStu;
		this.fnameStu = fnameStu;
		this.lnameStu = lnameStu;
		this.telStu = telStu;
		this.emailStu = emailStu;
	}
	public Student() {
		super();
	}
	
	public String getiDCardStu() {
		return iDCardStu;
	}
	public void setiDCardStu(String iDCardStu) {
		this.iDCardStu = iDCardStu;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getPassWordStu() {
		return passWordStu;
	}
	public void setPassWordStu(String passWordStu) {
		this.passWordStu = passWordStu;
	}
	public String getFnameStu() {
		return fnameStu;
	}
	public void setFnameStu(String fnameStu) {
		this.fnameStu = fnameStu;
	}
	public String getLnameStu() {
		return lnameStu;
	}
	public void setLnameStu(String lnameStu) {
		this.lnameStu = lnameStu;
	}
	public String getTelStu() {
		return telStu;
	}
	public void setTelStu(String telStu) {
		this.telStu = telStu;
	}
	public String getEmailStu() {
		return emailStu;
	}
	public void setEmailStu(String emailStu) {
		this.emailStu = emailStu;
	}
	public ArrayList<ClassRoom> getListClassRoom() {
		return listClassRoom;
	}
	
}
