package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSortingAlgorithm {

	public static void main(String[] args) {
		

		Scanner scanner=new Scanner(System.in);
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		System.out.println("Enter the size of an Array");
		int sizeOfList=scanner.nextInt();
		System.out.println("Enter the array elements");
		for(int i=0;i<sizeOfList;i++) {
			arrayList.add(scanner.nextInt());
		}
		
		int key=0;//value holder
		int j=0;
		for(int i=1;i<arrayList.size();i++) { // i must be starts with 1
			key=arrayList.get(i);// i position //2   //3
			j=i-1;//0 postion tarverser //j=1
			while(j >= 0 && arrayList.get(j) > key) {
				arrayList.set(j+1, arrayList.get(j));
			
			}
			
			arrayList.set(j+1, key);
		}
		System.out.println(arrayList);
		scanner.close();
		
		
		

	}

}
