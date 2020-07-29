package helper;

import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SearchBookHelper {

	public static void searchBook(Frame f,String type, String s)
	{
		DbmsHelper.init();
		String addQuery,s1="The required Book is "+"\n";
		
		if(type.equalsIgnoreCase("Accession number"))
			addQuery ="select * from librarymanagementjava.books where `Acc_no` = "+Integer.parseInt(s);
		else
			addQuery="select * from librarymanagementjava.books where `"+type+"` ='"+s+"'";
		try {
			ResultSet rs=DbmsHelper.stmt.executeQuery(addQuery);
		
			while(rs.next()){
				
				for(int i=1;i<=5;i++)  
					s1=s1+rs.getString(i)+" , ";
				}
			JOptionPane.showMessageDialog(f,s1);
			//System.out.println(s1);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		searchBook("Title","Java");
	}*/

}
