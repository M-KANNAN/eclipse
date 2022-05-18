package Training;

import java.util.ArrayList;
import java.util.Scanner;

public class Program10 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<Integer>();
		System.out.println("Enter the size ");
		int len=scanner.nextInt();
		System.out.println("Enter the array elements :");
		for(int i=0;i<len;i++) {
			list.add(scanner.nextInt());
		}
		while(list.size()-1 > 0) {
			System.out.print(list.get(list.size() -1 )+" "+list.get(0)+" ");
			list.remove(list.size()-1);
			list.remove(0);
		}
		if(list.size() == 1) {
			System.out.print(list.get(0));
		}
		scanner.close();
	}

}
