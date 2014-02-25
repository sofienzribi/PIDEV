package tn.edu.esprit.gl8.tunisianWatch.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Entity implementation class for Entity: User
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User extends Person implements Serializable {

	public User(String mail, String login, String password, Boolean status,
			String firstName, String lastName, String phone) {
		super(mail, login, password);
		this.status = status;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}

	private Boolean status;
	private String firstName;
	private String lastName;
	private String phone;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
