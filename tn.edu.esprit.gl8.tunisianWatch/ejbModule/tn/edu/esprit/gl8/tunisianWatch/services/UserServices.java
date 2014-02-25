package tn.edu.esprit.gl8.tunisianWatch.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.gl8.tunisianWatch.domain.Person;
import tn.edu.esprit.gl8.tunisianWatch.impl.UserServicesLocal;
import tn.edu.esprit.gl8.tunisianWatch.impl.UserServicesRemote;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addPerson(Person person) {
		entityManager.persist(person);

	}

	@Override
	public void deleteUser(Person person) {
		entityManager.remove(entityManager.merge(person));

	}

	@Override
	public void updatePerson(Person person) {
		entityManager.merge(person);

	}

	@Override
	public Person getPersonById(int idPerson) {
		Person person = entityManager.find(Person.class, idPerson);
		return person;

	}

	@Override
	public Person login(String login, String password) {
		String jpql = "select u from Person u where u.login = :param1 and u.password= :param2";
		Query query = entityManager.createQuery(jpql);
		Person userFound=new Person();
		query.setParameter("param1", login);
		query.setParameter("param2", password);
 
try {
	userFound= (Person) query.getSingleResult();
		
		} catch (Exception e) {
			userFound=null;
		}
		 
		
		return userFound;
	}

}
