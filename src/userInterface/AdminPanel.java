package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import helper.ViewBooksHelper;
import helper.ViewIssueBookHelper;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel {

	private JFrame frame;
	String args[]= {};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
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
	public AdminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Admin Panel ");
		frame.setBounds(100, 100, 500, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel welLabel = new JLabel("Welcome Admin,");
		welLabel.setBounds(10, 11, 138, 14);
		frame.getContentPane().add(welLabel);

		JButton addBooks = new JButton("Add Books");
		addBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String abc[] = {};
				AddBooks.main(abc);
			}
		});
		addBooks.setBounds(165, 33, 169, 23);
		frame.getContentPane().add(addBooks);

		JButton viewBooks = new JButton("View Books");
		viewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBooksHelper.viewBooks(frame);
			}
		});
		viewBooks.setBounds(165, 67, 169, 23);
		frame.getContentPane().add(viewBooks);

		JButton issueBooks = new JButton("Issue Books");
		issueBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[]= {};
				IssueBook.main(args);
			}
		});
		issueBooks.setBounds(165, 169, 169, 23);
		frame.getContentPane().add(issueBooks);

		JButton viewIssueBooks = new JButton("View Issued Books");
		viewIssueBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewIssueBookHelper.viewIssuedBooks(frame);
			}
		});
		viewIssueBooks.setBounds(165, 203, 169, 23);
		frame.getContentPane().add(viewIssueBooks);

		JButton returnBooks = new JButton("Return Books");
		returnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[]= {};
				ReturnBook.main(args);
			}
		});
		returnBooks.setBounds(165, 237, 169, 23);
		frame.getContentPane().add(returnBooks);

		JButton logOut = new JButton("Logout");
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "Do you really want to logout?");
				if (ans == 0) {
					JOptionPane.showMessageDialog(frame, "Successfully logged out");
					System.exit(0);
				}
			}
		});
		logOut.setBounds(165, 271, 169, 23);
		frame.getContentPane().add(logOut);

		JButton upDateBook = new JButton("Update Books");
		upDateBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateBooks.main(args);
			}
		});
		upDateBook.setBounds(165, 135, 169, 23);
		frame.getContentPane().add(upDateBook);
		
		JButton searchBtn = new JButton("Search Books");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SearchBook.main(args);
			}
			
		});
		searchBtn.setBounds(165, 101, 169, 23);
		frame.getContentPane().add(searchBtn);
	}
}
