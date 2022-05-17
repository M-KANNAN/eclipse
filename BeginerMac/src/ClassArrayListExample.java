import java.util.ArrayList;

public class ClassArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[]=new int[10];
		for(int i=0;i<a.length;i++) {
			a[i]=i;
		}
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		for(int i=0;i<a.length;i++) {
			arrayList.add(new Integer(a[i]));
	 	}
		System.out.println("Size of array : "+arrayList.size());
		System.out.println("Remove() : "+arrayList.remove(0));
		System.out.println("Size of array afterremoval : "+arrayList.size());
		System.out.println("After the removal of element 0 : "+arrayList.toString());
		System.out.println("Arraylist contains 2 or not : "+arrayList.contains(2));
		System.out.println("index of element 8 : "+arrayList.indexOf(8));
		System.out.println(arrayList.add(2));
		System.out.println("clear" +arrayList.removeAll(arrayList));
		System.out.println(arrayList);
		
	}

}
