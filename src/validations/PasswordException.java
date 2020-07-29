package validations;

public class PasswordException {

	public static void validatePassword(String p, String rp) throws InvalidPasswordException {
		if (p.equals(rp)==false)
			throw new InvalidPasswordException("The passwords doesn't match");
	}
}
