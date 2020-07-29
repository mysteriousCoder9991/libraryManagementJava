package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import helper.AddBooksHelper;
import validations.BooksFillupException;
import validations.IncompleteFormException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBooks {

	private JFrame frame;
	private JTextField bookName;
	private JTextField accNo;
	private JTextField pubName;
	private JLabel nocaLabel;
	private JTextField noca;
	private JLabel authorNameLab;
	private JTextField authName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBooks window = new AddBooks();
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
	public AddBooks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Add Books");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel bookNamLab = new JLabel("Book Name");
		bookNamLab.setHorizontalAlignment(SwingConstants.CENTER);
		bookNamLab.setBounds(10, 42, 89, 14);
		frame.getContentPane().add(bookNamLab);
		
		bookName = new JTextField();
		bookName.setBounds(134, 39, 266, 20);
		frame.getContentPane().add(bookName);
		bookName.setColumns(10);
		
		JLabel accessNumLab = new JLabel("Accession Number");
		accessNumLab.setHorizontalAlignment(SwingConstants.CENTER);
		accessNumLab.setBounds(10, 11, 121, 14);
		frame.getContentPane().add(accessNumLab);
		
		accNo = new JTextField();
		accNo.setBounds(134, 8, 266, 20);
		frame.getContentPane().add(accNo);
		accNo.setColumns(10);
		
		JLabel publisherNameLabel = new JLabel("Publisher Name");
		publisherNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		publisherNameLabel.setBounds(10, 101, 114, 14);
		frame.getContentPane().add(publisherNameLabel);
		
		pubName = new JTextField();
		pubName.setBounds(134, 98, 266, 20);
		frame.getContentPane().add(pubName);
		pubName.setColumns(10);
		
		nocaLabel = new JLabel("Number of copies availabe");
		nocaLabel.setBounds(10, 123, 171, 38);
		frame.getContentPane().add(nocaLabel);
		
		noca = new JTextField();
		noca.setBounds(219, 125, 181, 20);
		frame.getContentPane().add(noca);
		noca.setColumns(10);
		
		JButton addBookBtn = new JButton("Add Book ");
		addBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int acc=Integer.parseInt(accNo.getText());
					String title=bookName.getText();
					String author=authName.getText();
					String pub=pubName.getText();
					int no=Integer.parseInt(noca.getText());
					BooksFillupException.checkBookForm(acc, title, author, pub, no);
					boolean t=AddBooksHelper.addBooks(acc, title, author, pub, no);
					if (t)
						JOptionPane.showMessageDialog(frame, "Book Added Successfully");
					else
						JOptionPane.showMessageDialog(frame, "The Books couldn't be added");
				}
				catch(IncompleteFormException e1)
				{
					JOptionPane.showMessageDialog(frame, "Incomplete Form");
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(frame, e2);
				}
				
				
			}
		});
		addBookBtn.setBounds(38, 183, 121, 23);
		frame.getContentPane().add(addBookBtn);
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String abc[]= {};
				AdminPanel.main(abc);
			}
		});
		backBtn.setBounds(219, 183, 99, 23);
		frame.getContentPane().add(backBtn);
		
		authorNameLab = new JLabel("Author Name");
		authorNameLab.setHorizontalAlignment(SwingConstants.CENTER);
		authorNameLab.setBounds(10, 67, 99, 23);
		frame.getContentPane().add(authorNameLab);
		
		authName = new JTextField();
		authName.setBounds(134, 70, 266, 20);
		frame.getContentPane().add(authName);
		authName.setColumns(10);
	}
}
