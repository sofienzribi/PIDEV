package tn.edu.esprit.gl8.tunisianWatch.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

/**
 * Entity implementation class for Entity: Administrator
 * 
 */
@Entity
@Inheritance
public class Administrator extends Person implements Serializable {

	public Administrator(String mail, String login, String password, String role) {
		super(mail, login, password);
		this.role = role;
	}

	private String role;
	private static final long serialVersionUID = 1L;

	public Administrator() {
		super();
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
