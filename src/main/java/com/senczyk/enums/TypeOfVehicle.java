package com.senczyk.enums;

public enum TypeOfVehicle {
	CAR("car"), BIKE("bike");
	
	String type;

	private TypeOfVehicle(String code) {
		this.type = code;
	}

	public String getTypeOfVehicle() {
		return type;
	}
	
}
