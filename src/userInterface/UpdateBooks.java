package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import helper.UpdateBooksHelper;
import validations.ValueException;
import validations.ValueExceptionClass;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateBooks {

	private JFrame frame;
	private JTextField accNo;
	private JTextField nocUpdate;
	String args[] = {};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBooks window = new UpdateBooks();
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
	public UpdateBooks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Update Book");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel accNoLab = new JLabel("Enter the Accession Number");
		accNoLab.setHorizontalAlignment(SwingConstants.CENTER);
		accNoLab.setBounds(10, 28, 223, 14);
		frame.getContentPane().add(accNoLab);

		accNo = new JTextField();
		accNo.setBounds(56, 53, 259, 20);
		frame.getContentPane().add(accNo);
		accNo.setColumns(10);

		JLabel updateCopiesLabel = new JLabel("Enter the number of copies available");
		updateCopiesLabel.setBounds(48, 84, 267, 14);
		frame.getContentPane().add(updateCopiesLabel);

		nocUpdate = new JTextField();
		nocUpdate.setBounds(58, 113, 257, 20);
		frame.getContentPane().add(nocUpdate);
		nocUpdate.setColumns(10);

		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a = Integer.parseInt(accNo.getText());
					int up = Integer.parseInt(nocUpdate.getText());
					ValueExceptionClass.valueCheck(a, up);
					UpdateBooksHelper.updateBooks(frame, a, up);
				} catch (ValueException e2) {
					JOptionPane.showMessageDialog(frame, e2);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, e1);
				}
			}
		});
		update.setBounds(28, 183, 89, 23);
		frame.getContentPane().add(update);

		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel.main(args);
			}
		});
		back.setBounds(176, 183, 89, 23);
		frame.getContentPane().add(back);
	}

}
