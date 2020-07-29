package validations;

public class BooksFillupException {

	public static void checkBookForm(int acc,String n,String a, String p,int noc) throws IncompleteFormException
	{
		if(acc<0||n.length()==0||a.length()==0||p.length()==0||noc<0)
			throw new IncompleteFormException("Incomplete Form");
	}
}
