package validations;

public class CheckEmail {

	public static void validateEmail(String em) throws InvalidEmailException{
		
		if(em.indexOf('@')==-1&&em.indexOf('.')==-1)
			throw new InvalidEmailException("Invalid Email ");
	}
}
