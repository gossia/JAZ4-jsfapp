package com.example.servletjspdemo.domain;

public class Person {
	
	private String firstName;
	private String lastName;
	private String organisation;
	private String email;
	private String email_confirm;
	private String source;
	private String otherSource;
	private String job;
	
	public Person() {
		super();
	}
	
	public Person(String firstName, String lastName, String organisation, String email, String email_confirm, String source, String otherSource, String job) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.organisation = organisation;
		this.email = email;
		this.email_confirm = email_confirm;
		this.source = source;
		this.otherSource = otherSource;
		this.job = job;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail_confirm() {
		return email_confirm;
	}

	public void setEmail_confirm(String email_confirm) {
		this.email_confirm = email_confirm;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getOtherSource() {
		return otherSource;
	}

	public void setOtherSource(String otherSource) {
		this.otherSource = otherSource;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
}
