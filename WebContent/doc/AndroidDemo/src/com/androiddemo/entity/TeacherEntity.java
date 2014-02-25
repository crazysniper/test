package com.androiddemo.entity;

import java.io.Serializable;

public class TeacherEntity implements Serializable {

	private static final long serialVersionUID = -8192668749866413829L;

	private int tecId;
	private String tecName;
	private int tecAge;

	public int getTecId() {
		return tecId;
	}

	public void setTecId(int tecId) {
		this.tecId = tecId;
	}

	public String getTecName() {
		return tecName;
	}

	public void setTecName(String tecName) {
		this.tecName = tecName;
	}

	public int getTecAge() {
		return tecAge;
	}

	public void setTecAge(int tecAge) {
		this.tecAge = tecAge;
	}

}
