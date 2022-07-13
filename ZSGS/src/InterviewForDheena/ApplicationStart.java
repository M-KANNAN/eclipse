package InterviewForDheena;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map.Entry;



public class ApplicationStart {
	ArrayList<One> arrayList=new ArrayList<One>();
	
	private void examMethod() {
		// TODO Auto-generated method stub
		
		ArrayList<Object> integers[]=new  ArrayList[2];
		integers[0]= new ArrayList<Object>(Arrays.asList(1,'C',"hai",4,5));
		integers[1]= new ArrayList<Object>(Arrays.asList(6,7,"123345639",12346789,10));
		
		
		
		Two two=new Two(integers);
		One one = new One("Array",two);
		arrayList.add(one);
		
		for(One one2 : arrayList) {
			for(Entry<String, Two> entry : one2.hashMap.entrySet()) {
				System.out.println(entry.getKey());
				for(ArrayList<Object> obj: entry.getValue().integers) {
					System.out.println(obj);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new ApplicationStart().examMethod();
	}
}
