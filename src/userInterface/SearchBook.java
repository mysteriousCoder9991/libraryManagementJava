package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

import helper.SearchBookHelper;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchBook {

	private JFrame frame;
	private JTextField search;
	int index;
	String choices[]= {"Accession number", "Title", "Author", "Publisher"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBook window = new SearchBook();
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
	public SearchBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		frame.setTitle("Search Book");
		frame.setBounds(100, 100, 597, 342);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.getContentPane().setLayout(null);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index=comboBox.getSelectedIndex();
			}
		});
		comboBox.setBounds(77, 33, 374, 38);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Accession number", "Title", "Author", "Publisher"}));
		frame.getContentPane().add(comboBox);
		
		search = new JTextField();
		search.setBounds(77, 143, 374, 38);
		frame.getContentPane().add(search);
		search.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setBounds(77, 109, 95, 24);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JButton searchBtn = new JButton("Ok");
		searchBtn.setBounds(468, 143, 103, 38);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchBookHelper.searchBook(frame,choices[index], search.getText());
			}
		});
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(searchBtn);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String abc[]= {};
				AdminPanel.main(abc);
			}
		});
		back.setBounds(143, 227, 155, 23);
		frame.getContentPane().add(back);
		
		
	}
}