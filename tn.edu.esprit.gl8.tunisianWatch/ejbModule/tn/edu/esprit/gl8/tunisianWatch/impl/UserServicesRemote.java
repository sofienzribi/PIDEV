package tn.edu.esprit.gl8.tunisianWatch.impl;

import javax.ejb.Remote;


import tn.edu.esprit.gl8.tunisianWatch.domain.Person;

@Remote
public interface UserServicesRemote {
	public void addPerson(Person person);

	public void deleteUser(Person person);

	public void updatePerson(Person person);
	
	public Person  getPersonById(int idPerson);
	public Person login(String login,String password);

}
