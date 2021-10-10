/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Oct 10, 2021
 */
package controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
/**
 * @author Andrew Pierce - ajpierce1
 */
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	/**
	 * 
	 */
	public LocalDateAttributeConverter() {
		// TODO Auto-generated constructor stub
	}
	
	public Date convertToDatabaseColumn(LocalDate attribute) {
		return (attribute == null ? null : Date.valueOf(attribute));
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		// TODO Auto-generated method stub
		return (dbData == null ? null : dbData.toLocalDate());
	}
	
	

}
