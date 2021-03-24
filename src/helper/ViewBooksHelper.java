package helper;

import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ViewBooksHelper {
	public static void viewBooks(Frame f)
	{
		DbmsHelper.init();
		String addQuery="SELECT * FROM librarymanagementjava.books;";
		System.out.println(DbmsHelper.con);
		String s="The Books are (in the format Accession Number , Title, Author, Publisher's Name , No. of copies available ) : "+"\n";
		try {
			ResultSet rs=DbmsHelper.stmt.executeQuery(addQuery);
		
			while(rs.next()){
				
				for(int i=1;i<=5;i++)  
					s=s+rs.getString(i)+" , ";
				s=s+"\n";
				}
			JOptionPane.showMessageDialog(f,s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
