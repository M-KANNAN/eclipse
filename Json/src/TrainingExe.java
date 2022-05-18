
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class User{
	int age1;
	String name;
	User(String name,int age){ 
		this.name=name;
		age1=age;
	}
	
}




public class TrainingExe {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ArrayList<Integer> arrayList=new ArrayList<Integer>();
//		ArrayList<Integer> arrayList1=new ArrayList<Integer>();
//		
//		arrayList1.add(6);
//		arrayList1.add(7);
//		arrayList1.add(2);
//		arrayList1.add(1);
		
//		Scanner  scanner=new Scanner(System.in);
//		System.out.println("Enter size ");
//		int size=scanner.nextInt();
//		System.out.println("Enter array elements");
//		for(int i=0;i<size;i++) {
//			arrayList.add(scanner.nextInt());
//
//	
//		}
		//arrayList.addAll(arrayList1);
		//System.out.println(arrayList);
		//System.out.println(arrayList1);
		
//		arrayList1.clear();
//		System.out.println(arrayList1);
		
//		arrayList1.set(0, 10);
//		System.out.println(arrayList1);
		
//		System.out.println(arrayList1.contains(6));
		
//		System.out.println(arrayList1.indexOf(7));
		
//		System.out.println(arrayList1.lastIndexOf(7));
		
//		for(int i=0;i<arrayList1.size();i++) {
//			System.out.println(arrayList1.get(i));
//		}
//		
		
	//	System.out.println(arrayList1.get(0));
		
//		Collections.sort(arrayList1,Collections.reverseOrder());
//		System.out.println(arrayList1);
		
//		Collections.reverse(arrayList1);
//		System.out.println(arrayList1);
		
		
		ArrayList<User> arrayList=new ArrayList<User>();
		User user=new User("Kanna", 10);
		User user1=new User("Robin", 10);
		
		arrayList.add(user);
		arrayList.add(user1); //Data encoding
		
		System.out.println(arrayList);
		
		for(User obj:arrayList) { //data decoding
			System.out.println(obj.name);
			System.out.println(obj.age1);
			
		}
		
		
		
		
		

	}

}
