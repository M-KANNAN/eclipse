import java.util.ArrayList;
import java.util.Scanner;

public class RemoveEvenNumbersInArray {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		System.out.println("Enter array size ");
		int len=scanner.nextInt();
		System.out.println("Enter the array elements");
		for(int i=0;i<len;i++) {
			arrayList.add(scanner.nextInt());
		}
		
		for(int i=0;i<arrayList.size();i++) {
			if(arrayList.get(i) % 2 == 0) {
				arrayList.remove(i);
				i--;
			}
			else {
				continue;
			}
		}
		System.out.println(arrayList);

	}

}
