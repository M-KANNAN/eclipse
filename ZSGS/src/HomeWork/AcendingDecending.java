package HomeWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AcendingDecending {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the length");
		int len=scanner.nextInt();
		System.out.println("Enter the array elements");
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		for(int i=0;i<len;i++) {
			arrayList.add(scanner.nextInt());
		}
		
		ArrayList<Integer> oddArray=new ArrayList<Integer>();
		ArrayList<Integer> evenArray=new ArrayList<Integer>();
		
		for(int i=0;i<arrayList.size();i=i+2) {
			oddArray.add(arrayList.get(i));
		}
		for(int i=1;i<arrayList.size();i=i+2) {
			evenArray.add(arrayList.get(i));
		}
		Collections.sort(oddArray,Collections.reverseOrder());
		Collections.sort(evenArray);
		arrayList.clear();
		for(int i=0;i<oddArray.size();i++) {
			if(i < oddArray.size()) {
				arrayList.add(oddArray.get(i));
			}
			if(i < evenArray.size()) {
				arrayList.add(evenArray.get(i));
			}
			
		}
		System.out.println(arrayList);
		scanner.close();

	}

}
