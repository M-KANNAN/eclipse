import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class DateAndCalenderExample {
	
	
	

	public static void main(String[] args) {
		
//	Calendar calendar=Calendar.getInstance();
//		
//		Date date=calendar.getTime();
//		System.out.println(date);
//		
//		String s1="ssadf";
//		String s2="ab";
//		System.out.println(s1.compareTo(s2));
//		System.out.println(s1.compareToIgnoreCase(s2));
		
//		char arr[]="aabbcd".toCharArray();
//		int count=0;
//		HashMap<Character, Integer> hashMap=new LinkedHashMap<Character, Integer>();
//		for(char c : arr) {
//			if(!hashMap.containsKey(c)) {
//				hashMap.put(c, 1);
//			}
//			else {
//				count=hashMap.get(c);
//				hashMap.put(c, ++count);
//			}
//		}
//		String s1="aabcd";
//        ArrayList<String> list=new ArrayList<String>(Arrays.asList(s1.split("")));
//        Collections.sort(list);
//        ArrayList<Integer> arrayList=new ArrayList<Integer>();
//        ArrayList<String> temp=new  ArrayList<String>();
//        for(String obj : list) {
//            if(!temp.contains(obj)) {
//                temp.add(obj);
//                arrayList.add(Collections.frequency(list, obj));
//            }
//        }
//       Collections.sort(arrayList);
//       System.out.println(arrayList);
//       int count=0;
//       for(int i=0;i<arrayList.size()-1;i++) {
//          
//           if(arrayList.get(i) == arrayList.get(i+1)) {
//               continue;
//           }
//           else if(arrayList.get(i) == arrayList.get(i+1) -1  && count <= 1)           {
//               arrayList.remove(i+1);
//               count++;
//                i--;
//           }
//           else {
//               count++;
//               break;
//           }
//       }
//       System.out.println(count);
      //return (count >= 2 )?  "NO" : "YES";
       Scanner sc=new Scanner(System.in);
       int count=0;
       while(true) {
    	   String s1=sc.nextLine();
    	   if(s1.strip().equals("")|| s1.isEmpty()|| s1.isBlank() || s1.trim().equals("")) {
    		   System.out.println(++count);
    	   }
       }
       
	}

}
