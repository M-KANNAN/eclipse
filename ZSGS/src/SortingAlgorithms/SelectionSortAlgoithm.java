package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectionSortAlgoithm {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		System.out.println("Enter the size of an Array");
		int sizeOfList=scanner.nextInt();
		System.out.println("Enter the array elements");
		for(int i=0;i<sizeOfList;i++) {
			arrayList.add(scanner.nextInt());
		}

		//Sorting algorithm using simple index swaping
		
		int minIndex=0;
		int temp=0;
		for(int i=0;i<arrayList.size()-1;i++) { // we can use -1 because it will fininsh 1 time before
			minIndex=i;
			for(int j=i+1;j<arrayList.size();j++) {
				if(arrayList.get(minIndex) > arrayList.get(j)) {
					minIndex=j; // swap index position in selection sorting algorithm
				}
			}
			temp=arrayList.get(minIndex);
			arrayList.set(minIndex, arrayList.get(i));
			arrayList.set(i, temp);
			
		}
		System.out.println(arrayList);
		scanner.close();

	}

}
