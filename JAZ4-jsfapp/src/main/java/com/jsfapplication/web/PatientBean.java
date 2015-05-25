package com.jsfapplication.web;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.jsfapplication.domain.Patient;
import com.jsfapplication.service.PatientManager;


@SessionScoped
@Named("patientBean")
public class PatientBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Patient patient = new Patient();
	private ListDataModel<Patient> patients = new ListDataModel<Patient>();
	
	@Inject
	private PatientManager pm;

	//private PatientManager pm = new PatientManager();

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public void setPatients(ListDataModel<Patient> patients) {
		this.patients = patients;
	}
	
	public ListDataModel<Patient> getPatients() {
		patients.setWrappedData(pm.getAllPatients());
		return patients;
	}
	
	public String addPatient() {
		pm.addPatient(patient);
		
		patient.setDateOfBirth(null);
		patient.setFirstName("");
		patient.setLastName("");
		patient.setPesel("");
		patient.setAddress("");
		patient.setPhoneNumber("");
		patient.setWeight(0);
		patient.setHeight(0);
		patient.setEntryDate(null);
		
		return "showAll";
	}
	
	
	// Validator zgodnosci roku urodzenia z peselem

	public void validatePeselDob(ComponentSystemEvent event) {

		UIForm form = (UIForm) event.getComponent();
		UIInput pesel = (UIInput) form.findComponent("pesel");
		UIInput dateOfBirth = (UIInput) form.findComponent("dateOfBirth");

		if (pesel.getValue() != null && dateOfBirth.getValue() != null
				&& pesel.getValue().toString().length() >= 2) {
			String lastDigitsOfPesel = pesel.getValue().toString().substring(0, 2);
			Calendar cal = Calendar.getInstance();
			cal.setTime(((Date) dateOfBirth.getValue()));
			String lastDigitsOfDob = ((Integer) cal.get(Calendar.YEAR)).toString().substring(2);

			if (!lastDigitsOfPesel.equals(lastDigitsOfDob)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(form.getClientId(), new FacesMessage(
						"Rok urodzenia jest niezgodny z numerem PESEL"));
				context.renderResponse();
			}
		}	
	}
	
	// Validator unikalnosci peselu
	
	public void uniquePesel(FacesContext context, UIComponent component,
			Object value){

		String pesel = (String) value;
		
		for (Patient patient : pm.getAllPatients()) {
			if (patient.getPesel().equals(pesel)) {
				FacesMessage message = new FacesMessage(
						"Pacjent o tym numerze PESEL juz istnieje");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
}
