import java.util.ArrayList;
import java.util.Scanner;

public class DuplicateRemoval {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String s1=new String();
		System.out.println("Enter the String :");
		s1=scanner.nextLine();
		String arr[]=s1.split(" ");
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<arr.length;i++) {
			if(list.indexOf(arr[i]) == -1) {
				list.add(arr[i]);
			}
		}
		System.out.println(String.join(" ", list));

	}

}
