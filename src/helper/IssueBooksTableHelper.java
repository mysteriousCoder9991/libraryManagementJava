package helper;

import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IssueBooksTableHelper {
	static int issue_id = 0;

	public static void insertIssueTable(Frame f, int acc, int user, String obi, String dtbr) throws SQLException {
		/// DbmsHelper.init();
		IssueBooksHelper.searchBook(f, acc, user);
		obi=DaysAfter.convertDate(obi);
		dtbr=DaysAfter.convertDate(dtbr);
		String addQ = "insert into `librarymanagementjava`.`issue_table`values(" + issue_id + "," + acc + "," + user
				+ ",'" + obi + "','" + dtbr + "',null,null);";
		System.out.println(addQ);
		String noc = "select noca from `librarymanagementjava`.`books` where `Acc_no` = " + acc;
		String up = "";
		ResultSet rs = DbmsHelper.stmt.executeQuery(noc);
		while (rs.next()) {
			up = rs.getString(1);
		}
		int noc1 = Integer.parseInt(up) - 1;
		noc = Integer.toString(noc1);
		String updateQ = "update librarymanagementjava.books" + " set `noca` = '" + noc + "'" + "where `acc_No` = "
				+ acc + ";";
		try {
			DbmsHelper.stmt.execute(addQ);
			DbmsHelper.stmt.execute(updateQ);
			issue_id++;
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}