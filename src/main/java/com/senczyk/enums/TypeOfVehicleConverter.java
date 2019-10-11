package com.senczyk.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TypeOfVehicleConverter implements AttributeConverter<TypeOfVehicle, String> {

	@Override
	public String convertToDatabaseColumn(TypeOfVehicle attribute) {
		return attribute.getTypeOfVehicle();
	}

	@Override
	public TypeOfVehicle convertToEntityAttribute(String dbData) {
		return TypeOfVehicle.valueOf(dbData.toUpperCase());
	}
}
