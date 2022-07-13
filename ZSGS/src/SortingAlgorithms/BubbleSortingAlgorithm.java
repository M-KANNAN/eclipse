package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSortingAlgorithm {

	public static void main(String[] args) {
		

		Scanner scanner=new Scanner(System.in);
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		System.out.println("Enter the size of an Array");
		int sizeOfList=scanner.nextInt();
		System.out.println("Enter the array elements");
		for(int i=0;i<sizeOfList;i++) {
			arrayList.add(scanner.nextInt());
		}
		
		
		//Bubble sort is just swapping the two variables if the cobndition meets
		
		int temp=0;
		int count=0;
		
		for(int i=0;i<arrayList.size();i++) {
			for(int j=i+1;j<arrayList.size();j++) {
				if(arrayList.get(i) > arrayList.get(j)) {
					temp=arrayList.get(j);
					arrayList.set(j, arrayList.get(i));
					arrayList.set(i, temp);
					++count;
				}
			}
		}
		
		System.out.println(arrayList);
		scanner.close();
	}

}
