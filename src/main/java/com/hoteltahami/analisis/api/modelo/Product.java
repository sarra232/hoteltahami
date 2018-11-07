package com.hoteltahami.analisis.api.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proucto")
public class Product {
	
	@Id
	@Column(name="codigo")
	@GeneratedValue
	private String code;
	
	@Id
	@Column(name="nombre_p")
	@GeneratedValue
	private String name;
	
	@Id
	@Column(name="descripcion")
	@GeneratedValue
	private String description;
	
	@Id
	@Column(name="estado")
	@GeneratedValue
	private Boolean status;
	
	@Id
	@Column(name="iva")
	@GeneratedValue
	private double iva; //revisar
	
	@Id
	@Column(name="precio")
	@GeneratedValue
	private double pricesale;
	
	public Product() {
		super();
	}
	public Product(String code, String name, String description, Boolean status, double iva, double pricesale) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.status = status;
		this.iva = iva;
		this.pricesale = pricesale;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getPricesale() {
		return pricesale;
	}
	public void setPricesale(double pricesale) {
		this.pricesale = pricesale;
	}
	
	
	
}
