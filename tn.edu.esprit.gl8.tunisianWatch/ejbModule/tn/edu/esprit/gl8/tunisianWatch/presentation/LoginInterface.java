package tn.edu.esprit.gl8.tunisianWatch.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.JTextField;

import tn.edu.esprit.gl8.tunisianWatch.domain.Person;
import tn.edu.esprit.gl8.tunisianWatch.impl.UserServicesRemote;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginInterface extends JFrame {

	private JPanel contentPane;
	private JTextField LoginField;
	private JTextField PasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInterface frame = new LoginInterface();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(21, 44, 46, 14);
		contentPane.add(lblLogin);
		
		LoginField = new JTextField();
		LoginField.setBounds(125, 41, 86, 20);
		contentPane.add(LoginField);
		LoginField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(21, 108, 46, 14);
		contentPane.add(lblPassword);
		
		PasswordField = new JTextField();
		PasswordField.setBounds(125, 105, 86, 20);
		contentPane.add(PasswordField);
		PasswordField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			String password=PasswordField.getText();
			String login=LoginField.getText();
			Context context;
			try {
				context = new InitialContext();
				UserServicesRemote userServicesRemote = (UserServicesRemote) context
						.lookup("tn.edu.esprit.gl8.tunisianWatch/UserServices!tn.edu.esprit.gl8.tunisianWatch.impl.UserServicesRemote");

				Person userLoggedIn = userServicesRemote.login(login, password);
					
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
				
				
				
				
			}
		});
		btnLogin.setBounds(214, 172, 89, 23);
		contentPane.add(btnLogin);
	}
}
