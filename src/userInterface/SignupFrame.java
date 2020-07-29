package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import validations.CheckEmail;
import validations.IncompleteFormException;
import validations.Incomplete_Form;
import validations.InvalidEmailException;
import validations.InvalidPasswordException;
import validations.PasswordException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignupFrame {

	private JFrame frame;
	private JTextField firstName;
	private JPasswordField passwordField;
	private JTextField email;
	private JPasswordField passwordRepeat;
	private JTextField lastName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupFrame window = new SignupFrame();
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
	public SignupFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Separator.background"));
		frame.setTitle("Signup Profile");
		frame.setBounds(100, 100, 845, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Slider.focus"));
		panel.setForeground(UIManager.getColor("Separator.background"));
		panel.setBounds(0, 0, 393, 499);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel(" Hey there,");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 67));
		lblNewLabel.setBounds(10, 82, 383, 85);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(".....We got you......");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1.setBounds(10, 246, 373, 125);
		panel.add(lblNewLabel_1);

		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		firstNameLabel.setBounds(432, 10, 139, 31);
		frame.getContentPane().add(firstNameLabel);

		firstName = new JTextField();
		firstName.setBounds(453, 51, 342, 36);
		frame.getContentPane().add(firstName);
		firstName.setColumns(10);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordLabel.setBounds(433, 267, 120, 31);
		frame.getContentPane().add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(453, 308, 342, 31);
		frame.getContentPane().add(passwordField);

		JLabel repeatPasswordLabel = new JLabel("Email");
		repeatPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		repeatPasswordLabel.setBounds(432, 186, 98, 25);
		frame.getContentPane().add(repeatPasswordLabel);

		email = new JTextField();
		email.setBounds(453, 221, 342, 36);
		frame.getContentPane().add(email);
		email.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Repeat Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(432, 349, 139, 25);
		frame.getContentPane().add(lblNewLabel_5);

		passwordRepeat = new JPasswordField();
		passwordRepeat.setBounds(453, 384, 342, 36);
		frame.getContentPane().add(passwordRepeat);

		JButton signUp = new JButton("Sign Up");
		signUp.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String p = passwordField.getText();
				String rp = passwordRepeat.getText();
				String emailText = email.getText();
				String fn = firstName.getText(), ln = lastName.getText();
				try {
					Incomplete_Form.validateForm(fn, ln, emailText, p, rp);
					CheckEmail.validateEmail(emailText);
					PasswordException.validatePassword(p, rp);
					JOptionPane.showMessageDialog(frame, "Registration Successful");
				} catch (IncompleteFormException e1) {
					JOptionPane.showMessageDialog(frame, e1);
				} catch (InvalidEmailException e2) {
					JOptionPane.showMessageDialog(frame, e2);
				} catch (InvalidPasswordException e3) {
					JOptionPane.showMessageDialog(frame, e3);
				} catch (Exception e4) {
					JOptionPane.showMessageDialog(frame, e4);
				}
			}
		});
		signUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		signUp.setBounds(694, 431, 106, 31);
		frame.getContentPane().add(signUp);

		JLabel lblNewLabel_6 = new JLabel("Last Name");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(433, 95, 106, 25);
		frame.getContentPane().add(lblNewLabel_6);

		lastName = new JTextField();
		lastName.setBounds(453, 130, 342, 36);
		frame.getContentPane().add(lastName);
		lastName.setColumns(10);

		JButton login = new JButton("Already have account login now");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String abc[]= {};
				Login.main(abc);
			}
		});
		login.setFont(new Font("Tahoma", Font.PLAIN, 18));
		login.setBounds(423, 469, 312, 30);
		frame.getContentPane().add(login);
	}
}
