package helper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReturnBookHelper {

	public static double returnBooks(int acc, int user, String dor) {
		DbmsHelper.init();
		String q = "SELECT accNo,member_id ,dtbr  FROM librarymanagementjava.issue_table where `accNo` =" + acc
				+ " and `member_id` = " + user + ";";
		
		Object dorDb="";
		String ad="";
		ResultSet rs=null;
		try {
			rs=DbmsHelper.stmt.executeQuery(q);
			while(rs.next())
			{
				dorDb= rs.getObject(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ad=dorDb.toString();
		double fine=DaysBetweenCalculate.feesCalculate(dor, ad);
		if (fine<=0)
			fine=0;
		String upRec = "update librarymanagementjava.issue_table set `odbr`='"+dor+"',`fines`="+fine+" where accNo =" +acc;
		String getNoca= "select `noca` from librarymanagementjava.books where acc_No = "+acc+";";
		Object no="0";int n;
		rs=null;
		try {
			rs=DbmsHelper.stmt.executeQuery(getNoca);
			while(rs.next())
			{
				no= rs.getString("noca");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String no1=no.toString();
		n=Integer.parseInt(no1)+1;
		String upRecBooks = "update librarymanagementjava.books set `noca` = "+n+" where `acc_No`="+acc+"; ";
		try {
			DbmsHelper.stmt.execute(upRec);
			DbmsHelper.stmt.execute(upRecBooks);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fine;
		
	}
	
	/*public static void main(String agrs[])
	{
		returnBooks(1001,1500,"2020-07-29");
	}*/
}
