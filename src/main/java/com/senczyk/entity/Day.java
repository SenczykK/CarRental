package com.senczyk.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.senczyk.enums.*;

@Entity
public class Day {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date date;
	
	private TypeOfVehicle typeOfVehicle;
	
	private String nameOfVehicle;
	private String producerName;
	
	private Color color;
	
	private Date productionDate;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	private Date rentDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TypeOfVehicle getTypeOfVehicle() {
		return typeOfVehicle;
	}
	public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) {
		this.typeOfVehicle = typeOfVehicle;
	}
	public String getNameOfVehicle() {
		return nameOfVehicle;
	}
	public void setNameOfVehicle(String nameOfVehicle) {
		this.nameOfVehicle = nameOfVehicle;
	}
	public String getProducerName() {
		return producerName;
	}
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Date getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getRentDate() {
		return rentDate;
	}
	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}
}
