package tn.edu.esprit.gl8.tunisianWatchAppClient.presentation;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import tn.edu.esprit.gl8.tunisianWatch.domain.Person;
import tn.edu.esprit.gl8.tunisianWatch.domain.User;
import tn.edu.esprit.gl8.tunisianWatch.impl.UserServicesRemote;

public class LoginInterface extends JFrame {

	private JPanel contentPane;
	private JTextField LoginField;
	private JTextField PasswordField;
	private JButton btnLogin;
	private JLabel ErrorField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					LoginInterface frame = new LoginInterface();
					frame.ErrorField.setVisible(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginInterface() {
		setTitle("Authentification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(54, 60, 46, 14);
		contentPane.add(lblNewLabel);

		LoginField = new JTextField();
		LoginField.setBounds(213, 57, 86, 20);
		contentPane.add(LoginField);
		LoginField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(54, 138, 86, 14);
		contentPane.add(lblNewLabel_1);

		PasswordField = new JTextField();
		PasswordField.setBounds(213, 135, 86, 20);
		contentPane.add(PasswordField);
		PasswordField.setColumns(10);

		btnLogin = new JButton("Login");

		// LOGIN TEST
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String password = PasswordField.getText();
				String login = LoginField.getText();
				Context context;
				try {
					context = new InitialContext();
					UserServicesRemote userServicesRemote = (UserServicesRemote) context
							.lookup("tn.edu.esprit.gl8.tunisianWatch/UserServices!tn.edu.esprit.gl8.tunisianWatch.impl.UserServicesRemote");

					Person userLoggedIn = userServicesRemote.login(login,
							password);
					if (userLoggedIn == null) {
						LoginInterface.this.ErrorField.setVisible(true);

					} else {
						if (userLoggedIn instanceof User) {
							System.out.println("welcome Mr: "
									+ userLoggedIn.getMail());
							MainPageUser mainPageUser = new MainPageUser();
							mainPageUser.setVisible(true);
							LoginInterface.this.setVisible(false);

						} else {
							System.out.println("welcome Mr Administrator");
							MainPageAdmin pageAdmin = new MainPageAdmin();
							pageAdmin.setVisible(true);
							LoginInterface.this.setVisible(false);

						}
					}

				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(255, 205, 89, 23);
		contentPane.add(btnLogin);

		ErrorField = new JLabel("Login ou mdp incorrect");
		ErrorField.setBounds(151, 170, 206, 14);
		contentPane.add(ErrorField);
	}

}
