package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import validations.IncompleteFormException;
import validations.LoginException;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField name;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(160, 160, 160));
		frame.setTitle("Login Profile");
		// frame.setTitle("Login Profile ");
		frame.setBounds(100, 100, 720, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(100, 109, 136, 30);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(100, 184, 136, 30);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("LOGIN AS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_2.setBounds(100, 251, 136, 24);
		frame.getContentPane().add(lblNewLabel_2);

		name = new JTextField();
		name.setBounds(260, 109, 301, 30);
		frame.getContentPane().add(name);
		name.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(260, 184, 301, 30);
		frame.getContentPane().add(passwordField);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 21));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "ADMIN", "MEMBER" }));
		comboBox.setBounds(260, 251, 301, 30);
		frame.getContentPane().add(comboBox);

		JButton login = new JButton("LOGIN");
		login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String l = name.getText();
					String p = passwordField.getText();
					LoginException.loginCheck(l, p);
				} catch (IncompleteFormException e1) {
					JOptionPane.showMessageDialog(frame, "Incomplete Form");
				}

			}
		});
		login.setFont(new Font("Tahoma", Font.PLAIN, 20));
		login.setBounds(113, 328, 105, 24);
		frame.getContentPane().add(login);

		JButton forgotPassword = new JButton("FORGOT PASSWORD?");
		forgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Contact your admin to get the password");
			}
		});
		forgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		forgotPassword.setBounds(284, 328, 250, 24);
		frame.getContentPane().add(forgotPassword);

		JButton register = new JButton("DONT HAVE ACCOUNT REGISTER NOW");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[] = {};
				SignupFrame.main(args);
			}
		});
		register.setFont(new Font("Tahoma", Font.PLAIN, 20));
		register.setBounds(113, 369, 421, 23);
		frame.getContentPane().add(register);
	}

}
