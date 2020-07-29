package validations;

public class Incomplete_Form {

	public static void validateForm(String fn, String ln, String email, String p, String rp) throws IncompleteFormException {
		if (fn.length() ==0 && ln.length() == 0 && email.length() ==  0&& p.length() >= 1 && rp.length() >= 1)
			throw new IncompleteFormException("Incomplement form");

	}
}
