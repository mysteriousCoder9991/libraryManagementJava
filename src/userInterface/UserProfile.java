package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;

public class UserProfile {

	private JFrame frame;
	private JTextField Name;
	private JTextField userName;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserProfile window = new UserProfile ();
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
	public UserProfile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setTitle("User Profile ");
		frame.setTitle("User Profile ");
		frame.setBounds(100, 100, 597, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Name = new JTextField();
		Name.setBounds(219, 11, 223, 20);
		Name.setEditable(false);
		frame.getContentPane().add(Name);
		Name.setColumns(10);
		
		userName = new JTextField();
		userName.setBounds(219, 42, 223, 20);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		JLabel follow = new JLabel("Followers");
		follow.setBounds(10, 90, 141, 14);
		follow.setForeground(Color.WHITE);
		follow.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(follow);
		
		JLabel Following = new JLabel("Following");
		Following.setBounds(392, 90, 108, 14);
		Following.setForeground(Color.WHITE);
		Following.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(Following);
		
		table = new JTable();
		table.setBounds(80, 144, 491, 119);
		frame.getContentPane().add(table);
		
		JButton followBtn = new JButton("Follow");
		followBtn.setBounds(161, 86, 90, 23);
		frame.getContentPane().add(followBtn);
		
		JButton Unfollow = new JButton("Unfollow");
		Unfollow.setBounds(293, 86, 89, 23);
		Unfollow.setEnabled(false);
		frame.getContentPane().add(Unfollow);
		
		JLabel lblNewLabel = new JLabel("Pic will be \r\nadded in \r\nnext update");
		lblNewLabel.setBounds(10, 14, 108, 67);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
	}
}
