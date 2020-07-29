package helper;

import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ViewIssueBookHelper {
	public static void viewIssuedBooks(Frame f) {
		DbmsHelper.init();
		String addQuery = "SELECT * FROM librarymanagementjava.issue_table;";
		System.out.println(DbmsHelper.con);
		String s = "The Issued Books are " + "\n";
		try {
			ResultSet rs = DbmsHelper.stmt.executeQuery(addQuery);

			while (rs.next()) {

				for (int i = 1; i <= 5; i++)
					s = s + rs.getString(i) + " , ";
				s = s + "\n";
			}
			JOptionPane.showMessageDialog(f, s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * public static void main(String agrs[]) { viewIssuedBooks(); }
	 */
}
