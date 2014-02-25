package tn.edu.esprit.gl8.tunisianWatchAppClient.personTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.gl8.tunisianWatch.domain.Person;
import tn.edu.esprit.gl8.tunisianWatch.domain.User;
import tn.edu.esprit.gl8.tunisianWatch.impl.UserServicesRemote;

public class TestLogin {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			UserServicesRemote userServicesRemote = (UserServicesRemote) context
					.lookup("tn.edu.esprit.gl8.tunisianWatch/UserServices!tn.edu.esprit.gl8.tunisianWatch.impl.UserServicesRemote");

			Person userLoggedIn = userServicesRemote.login("ddd", "fff");
			if (userLoggedIn instanceof User) {
				System.out.println("welcome Mr: " + userLoggedIn.getMail());

			} else {
				System.out.println("welcome Mr Administrator");

			}

		} catch (NamingException e) {

			e.printStackTrace();
		}
	}

}
