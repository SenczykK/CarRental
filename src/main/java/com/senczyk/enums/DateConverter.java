package com.senczyk.enums;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class DateConverter implements AttributeConverter<Date, String> {

	
	@Override
	public String convertToDatabaseColumn(Date attribute) {
		DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		return f.format(attribute);
	}

	@Override
	public Date convertToEntityAttribute(String dbData) {
		
		DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
			try {		
				date =  f.parse(dbData);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		return date;
	}
}
