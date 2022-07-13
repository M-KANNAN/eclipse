package Interview;

public class Question3 {

	public static void main(String[] args) {
		int i=10;
		if(++i == 10 || ++i == 11) {
			System.out.println("IF part");
			System.out.println(i);
			
		}
		else {
			System.out.println("Else part");
			System.out.println(i);
		}

	}

}
