package helper;

import java.awt.Frame;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UpdateBooksHelper {

	public static void updateBooks(Frame f, int acc, int noc) {
		DbmsHelper.init();
		String addQuery = "update librarymanagementjava.books" + " set `noca` = '" + noc + "'" + "where `acc_No` = "
				+ acc + ";";
		// System.out.println(DbmsHelper.con);

		try {
			InvalidData.checkBookData(acc);
			DbmsHelper.stmt.execute(addQuery);
			JOptionPane.showMessageDialog(f, "Update Successful");
		} catch (SQLException | InvalidDataException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(f, "Update encountered a problem " +e);
			e.printStackTrace();
		}

	}

}
