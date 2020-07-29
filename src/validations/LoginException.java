package validations;

public class LoginException {

	
	public static void loginCheck(String n,String p) throws IncompleteFormException
	{
		if(n.length()<=3||p.length()<=0)
			throw new IncompleteFormException("Please fill all the required fields");
	}
}

