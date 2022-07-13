import java.util.ArrayList;
import java.util.Scanner;

public class SumOfArrayElementToTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		System.out.println("Enter array size ");
		int len=scanner.nextInt();
		System.out.println("Enter target element");
		int target=scanner.nextInt();
		System.out.println("Enter the array elements");
		for(int i=0;i<len;i++) {
			arrayList.add(scanner.nextInt());
		}
		ArrayList<Integer>  arrayList2=new ArrayList<Integer>();
		for(int i=0;i<arrayList.size();i++) {
			for(int j=0;j<arrayList.size();j++) {
				if( i != j) {
					if(arrayList.get(i) + arrayList.get(j) == target) {
						if(!arrayList2.contains(arrayList.get(i)) && !arrayList2.contains(arrayList.get(j))) {
							arrayList2.add(arrayList.get(i));
							arrayList2.add(arrayList.get(j));
							System.out.println(i+" "+j);
						}
							
					}
				}
			}
		}

	}

}
