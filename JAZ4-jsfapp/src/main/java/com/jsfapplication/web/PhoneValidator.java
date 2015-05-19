package com.jsfapplication.web;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.msv.verifier.identity.Matcher;

@FacesValidator("phoneValidator")
public class PhoneValidator implements Validator{
	
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		 
		String phoneNumber = (String) value;
	      
	    Pattern pattern = Pattern.compile("[0-9]{9}");
	    java.util.regex.Matcher matcher = pattern.matcher(phoneNumber);
	 
	    if (!phoneNumber.equals("") && !matcher.matches()) {
	    	FacesMessage message = new FacesMessage();
			message.setDetail("Nieprawid³owy numer telefonu");
			message.setSummary("Nieprawid³owy numer telefonu");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
	     }
	 }

	


}
