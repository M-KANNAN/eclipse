import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordCountUsingHashMap {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a String ");
		String arr[]=scanner.nextLine().toLowerCase().split(" ");
		HashMap<String, Integer> hashMap=new LinkedHashMap<String, Integer>();
		for(int i=0;i<arr.length;i++) {
			if(hashMap.containsKey(arr[i])) {
				Integer obj=hashMap.get(arr[i]);
				hashMap.replace(arr[i], obj, ++obj);
			}
			else {
				hashMap.put(arr[i],1);
			}
		}
		System.out.println(hashMap);
	}

}
