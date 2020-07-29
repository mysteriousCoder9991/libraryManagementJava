package helper;

import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class IssueBooksHelper {
	

	public static void searchBook(Frame f,int acc, int user) throws SQLException {
		DbmsHelper.init();
		ResultSet rs = null;
		int bc = 0, mc = 0;
		String searchBQ = "select `acc_no` from books ";
		try {
			rs = DbmsHelper.stmt.executeQuery(searchBQ);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			bc++;
		}
		System.out.println(bc);
		int accBooks[] = new int[bc];
		bc = 0;
		rs = DbmsHelper.stmt.executeQuery(searchBQ);
		while (rs.next()) {
			accBooks[bc++]=rs.getInt(1);
			
		}
		String memberQ="select `id` from members";
		
		try {
			rs = DbmsHelper.stmt.executeQuery(memberQ);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			mc++;
		}
		System.out.println(bc);
		int memberDb[] = new int[bc];
		mc = 0;
		rs = DbmsHelper.stmt.executeQuery(memberQ);
		while (rs.next()) {
			memberDb[mc++]=rs.getInt(1);
		}
		try {
			InvalidData.checkData(accBooks, memberDb, acc,user);
			JOptionPane.showMessageDialog(f, "Value found successfully");
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(f,e);
		}
		
		
	}

/*	public static void main(String agrs[]) {
		try {
			searchBook(1001, 1500);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
