package HomeWork;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class FamilyTree {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		HashMap<String, String> hashMap=new LinkedHashMap<String, String>();
		
		System.out.println("Enter the number of family memners :");
		int len=scanner.nextInt();
		String fatherName=null;
		String sonName=null;
		for(int i=0;i<len;i++) {
			System.out.println("Enter the son father pair "+(i+1));
			System.out.println("Enter the son name :");
			sonName=scanner.next();
			System.out.println("Enter the father name :");
			fatherName=scanner.next();
			hashMap.put(sonName,fatherName);
			
		}
		System.out.println("enter the grandFather name :");
		String grandFather=scanner.next();
				
		
		String sonOfGrandFather=null;
		
		Iterator<Entry<String, String>> iterator=hashMap.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, String> entry=iterator.next();
			if(grandFather.equalsIgnoreCase(entry.getValue())) {
				sonOfGrandFather=entry.getKey();
				break;
			}
		}
		int count=0;
		Iterator<Entry<String, String>> iterator1=hashMap.entrySet().iterator();
		while(iterator1.hasNext()) {
			Entry<String, String> entry=iterator1.next();
			if(sonOfGrandFather != null  && sonOfGrandFather.equalsIgnoreCase(entry.getValue())) {
				 count++;
			}
		}
		System.out.println("Number of grandChidren : "+count);
		scanner.close();
		
	}

}
