package Training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Program54 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<Integer>();
		ArrayList<Integer> odd=new ArrayList<Integer>();
		ArrayList<Integer> even=new ArrayList<Integer>();
		
		System.out.println("Enter the size of array :");
		int len=scanner.nextInt();
		System.out.println("Enter array elements : ");
		for(int i=0;i<len;i++) {
			list.add(scanner.nextInt());
		}
		
		for(int i=0;i<list.size();i++) {
			if(i % 2 == 0) {
				even.add(list.get(i));
			}
			else {
				odd.add(list.get(i));
			}
		}

		Collections.sort(odd);
		Collections.sort(even,Collections.reverseOrder());
		
		System.out.println(odd);
		System.out.println(even);
		
		list.clear();
		for(int i=0;i<even.size();i++) {
			
			if(i < even.size()) {
				list.add(even.get(i));
			}
			if(i < odd.size()) {
				list.add(odd.get(i));
			}
		}
			
		System.out.println(list);
		scanner.close();
	}

}
