import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LinkedLISTEX {

	public static void main(String[] args) {
	
		HashMap<Integer, String> hashMap=new LinkedHashMap<Integer, String>();
		hashMap.put(1,"Hai");
		hashMap.put(2,"Hello");
		hashMap.put(3,"World");
//		Iterator<Integer> iterator=hashMap.keySet().iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//			System.out.println(hashMap.get(iterator.next()));
//		}
		
		
//		while(iterator.hasNext()) {
//			Integer key=iterator.next();
//			System.out.println(key);
//			System.out.println(hashMap.get(key));
//		}
		
//		for(Entry<Integer, String> entry : hashMap.entrySet()) {
//			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
//			
//		}
		
		for(Entry<Integer, String> entry : hashMap.entrySet()) {
			entry.setValue("hai");
			
		}
		
		for(Entry<Integer, String> entry : hashMap.entrySet()) {
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
		
	}
		
		
	}

}
