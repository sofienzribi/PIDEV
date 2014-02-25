package tn.edu.esprit.gl8.tunisianWatchAppClient.personTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.gl8.tunisianWatch.domain.User;
import tn.edu.esprit.gl8.tunisianWatch.impl.UserServicesRemote;

public class TestUpdatePerson {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			UserServicesRemote userServicesRemote = (UserServicesRemote) context
					.lookup("ejb:/tn.edu.esprit.gl8.tunisianWatch/UserServices!tn.edu.esprit.gl8.tunisianWatch.impl.UserServicesRemote");

			User user = new User("ddd", "5555", "fff", true, "tttt", "yyyy",
					"uuu");
			user.setId(1);
			userServicesRemote.updatePerson(user);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
