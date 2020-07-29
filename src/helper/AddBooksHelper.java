package helper;

import java.sql.SQLException;

public class AddBooksHelper {

	public static boolean addBooks(int acc, String t, String a, String p, int noc) {
		DbmsHelper.init();
		String addQuery = "insert into `librarymanagementjava`.`books`values(" + acc + ",'" + t + "','" + a + "' ,'" + p
				+ "'," + noc + ");";
		// System.out.println(DbmsHelper.con);
		try {
			DbmsHelper.stmt.execute(addQuery);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

		// return true;

	}
	/*
	 * public static void main(String agrs[]) { addBooks(10,"abc","bca","a",540); }
	 */
}
