import java.util.Scanner;

public class ClassStringBuilderMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1=new String();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the string");
		s1=scanner.nextLine();
		StringBuilder builder=new StringBuilder(s1);
		System.out.println("isEmpty() : " +builder.isEmpty());
		System.out.println("insert() : "+builder.insert(1, "komali"));
		System.out.println("reverse() : "+builder.reverse());
		System.out.println("replace 1 characher with k : " +builder.replace(0, 1, "K"));
		builder.append("komali");
		System.out.println("After append : "+builder);

	}

}
//							SAMPLE OUTPUT
//Enter the string
//kanna
//isEmpty() : false
//insert() : kkomalianna
//reverse() : annailamokk
//Knnailamokk
//After append : Knnailamokkkomali
