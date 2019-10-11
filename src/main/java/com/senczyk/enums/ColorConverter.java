package com.senczyk.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ColorConverter implements AttributeConverter<Color, String> {

	@Override
	public String convertToDatabaseColumn(Color attribute) {
		return attribute.getColor();
	}

	@Override
	public Color convertToEntityAttribute(String dbData) {
		return Color.valueOf(dbData.toUpperCase());
	}
}
