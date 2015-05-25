package com.jsfapplication.web;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.jsfapplication.domain.Patient;
import com.jsfapplication.service.PatientManager;

@FacesValidator("peselValidator")
public class PeselValidator implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		String pesel = (String) value;
		Pattern pattern = Pattern.compile("[0-9]{11}");
	    java.util.regex.Matcher matcher = pattern.matcher(pesel);
	    
		if (!matcher.matches()) {
			FacesMessage message = new FacesMessage();
			message.setDetail("PESEL musi sk³adaæ siê z 11 cyfr");
			message.setSummary("PESEL musi sk³adaæ siê z 11 cyfr");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		
		if(sprawdz(pesel) == false) {
			FacesMessage message = new FacesMessage();
			message.setDetail("Nieprawid³owy numer PESEL");
			message.setSummary("Nieprawid³owy numer PESEL");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		
	}
	
	public static boolean sprawdz(String pesel){
			int[] wagi = {1, 3, 7, 9, 1, 3, 7 ,9 ,1 ,3};  // zak³adamy tablicê z wagami
			//if (pesel.length() != 11) return false;
			int suma = 0;  // zak³adamy zmienn¹ bêd¹c¹ sum¹ kontroln¹
			
			for (int i = 0; i < 10; i++)  // liczymy w pêtli sumê kontroln¹ przemna¿aj¹c odpowiednie
			suma += Integer.parseInt(pesel.substring(i, i+1)) * wagi[i];  // cyfry PESELU przez odpowiednie wagi
			
			int cyfraKontrolna = Integer.parseInt(pesel.substring(10, 11));  // pobieramy do zmiennej cyfraKontrolna wartoœæ ostatniej cyfry z PESELU
			suma %= 10;  // obliczamy cyfrê kontroln¹ z sumy (najpierw modulo 10 potem odejmujemy 10 i jeszcze raz modulo 10)
			suma = 10 - suma;
			suma %= 10;
			return (suma == cyfraKontrolna);  // zwracamy wartoœæ logiczn¹ porównania obliczonej i pobranej cyfry kontrolnej
	}
	
}