import java.util.regex.Pattern;

public class EmailAddressValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean validator=Pattern.compile("[a-zA-Z0-9]+").matcher("86").find();
		
		System.out.println(validator);
		
		

		
				

	}
}