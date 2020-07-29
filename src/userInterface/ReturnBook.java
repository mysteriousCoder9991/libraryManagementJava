package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import helper.ReturnBookHelper;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ReturnBook {

	private JFrame frame;
	private JTextField accNo;
	private JTextField userId;
	private JLabel dorLab;
	private JTextField dor;
	private JButton submit;
	private JButton back;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook window = new ReturnBook();
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
	public ReturnBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Return Book ");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel accNoLab = new JLabel("Enter the accession number");
		accNoLab.setHorizontalAlignment(SwingConstants.LEFT);
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
		user_id_label.setBounds(10, 69, 98, 14);
		frame.getContentPane().add(user_id_label);

		dorLab = new JLabel("Date of Return");
		dorLab.setBounds(10, 117, 158, 14);
		frame.getContentPane().add(dorLab);

		dor = new JTextField();
		dor.setBounds(213, 114, 211, 20);
		frame.getContentPane().add(dor);
		dor.setColumns(10);

		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate date = LocalDate.now();
				DateTimeFormatter obj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String d = date.format(obj);
				int acc = Integer.parseInt(accNo.getText());
				int mem = Integer.parseInt(userId.getText());
				double f = ReturnBookHelper.returnBooks(acc, mem, d);
				if (f > 0)
					JOptionPane.showMessageDialog(frame, " Total fines to be paid : " + f);
				JOptionPane.showMessageDialog(frame, "Book submitted successfully");

				// System.out.println(d);
			}
		});
		submit.setBounds(47, 188, 89, 23);
		frame.getContentPane().add(submit);

		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[] = {};
				AdminPanel.main(args);
			}
		});
		back.setBounds(225, 188, 89, 23);
		frame.getContentPane().add(back);

		JLabel hint = new JLabel("(yyyy-MM-dd) date format");
		hint.setHorizontalAlignment(SwingConstants.CENTER);
		hint.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		hint.setForeground(Color.GRAY);
		hint.setBounds(223, 145, 187, 14);
		frame.getContentPane().add(hint);
	}
}
