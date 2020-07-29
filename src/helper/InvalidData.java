package helper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InvalidData {

	

	public static void checkData(int[] accBooks, int[] memberDb, int acc, int user) throws InvalidDataException{
		// TODO Auto-generated method stub
		int i,f=0,f1=0;
		for(i=0;i<accBooks.length;i++)
		{
			if(acc==accBooks[i])
			{
				f=1;
				break;
			}
		}
		for(i=0;i<memberDb.length;i++)
		{
			if(user==memberDb[i])
			{
				f1=1;
				break;
			}
		}
		if(f==0||f1==0)
			throw new InvalidDataException("Value not found");
	}
	public static void checkBookData(int acc) throws InvalidDataException, SQLException{
		// TODO Auto-generated method stub
		DbmsHelper.init();
		ResultSet rs=null;
		int bc = 0;
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
		try {
			rs = DbmsHelper.stmt.executeQuery(searchBQ);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (rs.next()) {
			accBooks[bc++]=rs.getInt(1);
			
		}
		int i,f=0;
		for(i=0;i<accBooks.length;i++)
		{
			if(acc==accBooks[i])
			{
				f=1;
				break;
			}
		}
	
		if(f==0)
			throw new InvalidDataException("Value not found");
	}
}
