package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import helper.DaysAfter;
import helper.IssueBooksTableHelper;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class IssueBook {

	private JFrame frame;
	private JTextField accNo;
	private JTextField userId;
	private JTextField daysAfter;
	private int days;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook window = new IssueBook();
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
	public IssueBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Issue book ");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel accNoLab = new JLabel("Enter the accession number");
		accNoLab.setBounds(10, 27, 193, 14);
		frame.getContentPane().add(accNoLab);

		accNo = new JTextField();
		accNo.setBounds(213, 24, 211, 20);
		frame.getContentPane().add(accNo);
		accNo.setColumns(10);

		userId = new JTextField();
		userId.setBounds(213, 66, 211, 20);
		frame.getContentPane().add(userId);
		userId.setColumns(10);

		JLabel user_id_label = new JLabel("Enter User ID");
		user_id_label.setBounds(10, 69, 132, 14);
		frame.getContentPane().add(user_id_label);

		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[] = {};
				AdminPanel.main(args);
			}
		});
		back.setBounds(255, 167, 89, 23);
		frame.getContentPane().add(back);

		JLabel footer = new JLabel("* By default the return date is current date +7 days");
		footer.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		footer.setBounds(10, 218, 379, 14);
		frame.getContentPane().add(footer);

		JLabel footer2 = new JLabel("* Past due date , Rs 10 will charged per day\r\n");
		footer2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		footer2.setBounds(10, 236, 354, 14);
		frame.getContentPane().add(footer2);

		JLabel pdLab = new JLabel();
		pdLab.setBounds(10, 116, 158, 14);
		LocalDate date = LocalDate.now();
		DateTimeFormatter obj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String d = date.format(obj);
		pdLab.setText("Present Date : " + d);
		frame.getContentPane().add(pdLab);

		daysAfter = new JTextField();
		daysAfter.setText("7");
		daysAfter.setBounds(318, 113, 106, 20);
		frame.getContentPane().add(daysAfter);
		daysAfter.setColumns(10);

		JLabel dorLab = new JLabel("");
		dorLab.setBounds(10, 137, 258, 14);
		days = 7;
		days = Integer.parseInt(daysAfter.getText());
		String d1 = DaysAfter.process(d, days);
		dorLab.setText("Book to be returned on " + d1);
		frame.getContentPane().add(dorLab);

		JLabel daysAfterLab = new JLabel("Days after");
		daysAfterLab.setBounds(182, 116, 98, 14);
		frame.getContentPane().add(daysAfterLab);

		JButton issueBtn = new JButton("Issue Book");
		issueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int acc=Integer.parseInt(accNo.getText());
				int memId = Integer.parseInt(userId.getText());
				days = Integer.parseInt(daysAfter.getText());
				String d1 = DaysAfter.process(d, days);
				dorLab.setText("Book to be returned on " + d1);
				int i = JOptionPane.showConfirmDialog(frame, "Do you want to issue the book ?");
				if (i == 0)
				{	try {
					IssueBooksTableHelper.insertIssueTable(frame, acc, memId,d,d1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					JOptionPane.showMessageDialog(frame, "Book issued successfully");
				}
				else
					JOptionPane.showMessageDialog(frame, "Book not issued");
				daysAfter.setText("");
			}
		});
		issueBtn.setBounds(64, 167, 144, 23);
		frame.getContentPane().add(issueBtn);
	}
}
