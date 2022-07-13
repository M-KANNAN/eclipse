import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TripletsToZero {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		ArrayList<ArrayList<Integer>> arrayList=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> arrayList2=new ArrayList<Integer>();
		System.out.println("Enter array size ");
		int len=scanner.nextInt();
		System.out.println("Enter the array elements");
		for(int i=0;i<len;i++) {
			arrayList2.add(scanner.nextInt());
		}
		
		for(int i=0;i<arrayList2.size();i++) {
			for(int j=0;j<arrayList2.size();j++) {
					for(int k=0;k<arrayList2.size();k++) {
						if(i != j && i != k && j != k) {
								if(arrayList2.get(i) + arrayList2.get(j) + arrayList2.get(k) == 0) {
									
									ArrayList<Integer> arrayList3=new ArrayList<>(Arrays.asList(arrayList2.get(i),arrayList2.get(j),arrayList2.get(k)));
									Collections.sort(arrayList3);
									if(!arrayList.contains(arrayList3)) {
										arrayList.add(arrayList3);
									}
								}
							
						}
					}
				
			}
		}
		for(ArrayList<Integer> obj : arrayList) {
			System.out.println(obj);
		}

	}

}
