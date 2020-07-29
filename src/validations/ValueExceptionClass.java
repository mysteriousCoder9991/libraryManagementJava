package validations;

public class ValueExceptionClass {

	public static void valueCheck(int a,int up) throws ValueException {
		if(a<0||up<0)
			throw new ValueException("Invalid Value ");
	}
}
