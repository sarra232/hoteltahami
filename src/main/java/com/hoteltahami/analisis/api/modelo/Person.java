package com.hoteltahami.analisis.api.modelo;

public class Person {
	private String id;
	private String name;
	private String lastname;
	private String sex;
	private String telephone;
	private String address;
	private String email;
	private String password;
	public Person() {
		super();
	}
	public Person(String id, String name, String lastname, String sex, String telephone, String address, String email,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.sex = sex;
		this.telephone = telephone;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
