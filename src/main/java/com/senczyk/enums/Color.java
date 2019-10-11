package com.senczyk.enums;

public enum Color {
	RED("red"), GREEN("green"), BLUE("blue");
	
	String color;
	
	private Color(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	
}
