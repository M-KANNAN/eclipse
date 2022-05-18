package Training;

import java.util.ArrayList;
import java.util.Scanner;

public class Program9 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		ArrayList<Integer> array1=new ArrayList<Integer>();
		ArrayList<Integer> array2=new ArrayList<Integer>();
		System.out.println("Enter the size of array 1 :");
		int len1=scanner.nextInt();
		System.out.println("Enter array 1 ");
		for(int i=0;i<len1;i++) {
			array1.add(scanner.nextInt());
		}
		System.out.println("Enter the size of array 2 :");
		int len2=scanner.nextInt();
		System.out.println("Enter array 1 ");
		for(int i=0;i<len2;i++) {
			array2.add(scanner.nextInt());
		}
		for(int i =0;i<len1;i++) {
			if(!arrayList.contains(array1.get(i))) {
				arrayList.add(array1.get(i));
			}
		}
		for(int i =0;i<len2;i++) {
			if(!arrayList.contains(array2.get(i))) {
				arrayList.add(array2.get(i));
			}
		}
		System.out.println(arrayList);
		scanner.close();

	}

}
