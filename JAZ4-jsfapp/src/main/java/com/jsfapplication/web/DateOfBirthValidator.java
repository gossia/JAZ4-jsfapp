package com.jsfapplication.web;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dateOfBirthValidator")
public class DateOfBirthValidator implements Validator{
	
	public void validate(FacesContext context, UIComponent component,Object value)
			throws ValidatorException {
		
		Date dateOfBirth = (Date) value;
		Calendar cal = Calendar.getInstance();
		cal.setTime((dateOfBirth));
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(new Date());
		
		if(cal.after(cal2)){
			FacesMessage message = new FacesMessage();
			message.setDetail("Data urodzenia jest data z przyszlosci");
			message.setSummary("Data urodzenia jest data z przyszlosci");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}

}

