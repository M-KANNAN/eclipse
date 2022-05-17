import java.util.ArrayList;

public class ConstructorExample {

	public static void main(String[] args) {
//		int arr[]= {10,20,10,30,20,40,50,40};
//		Arrays.sort(arr);
//		Set<Integer> set=new HashSet<Integer>();
//		int j=0;
//		for(int i=0;i<arr.length;i++) {
//			set.add(arr[i]);
//		}
//		System.out.println(set);
		
//		ArrayList<Integer> list=new ArrayList<Integer>();
//		for(int i=0;i<arr.length;i++) {
//			if(list.indexOf(arr[i])==-1) {
//				list.add(arr[i]);
//			}
//		}
//		System.out.println(list);
		
		String s1="hai hello hai how are you";
		String arr[]=s1.split(" ");
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<arr.length;i++) {
			if(list.indexOf(arr[i]) == -1) {
				list.add(arr[i]);
			}
		}
		System.out.println(list);
		System.out.println(String.join(" ",list));
		
		for(int i=s1.length()-1;i>=0;i--) {
			System.out.print(s1.charAt(i));
		}
		System.out.println();
		
		for(int i=0;i<arr.length;i++) {
			StringBuilder builder=new StringBuilder(arr[i]);
			System.out.print(builder.reverse()+" ");
		}
		
		try {
			ArrayList<Integer> list1=new ArrayList<Integer>();
			int val=10;
			int n1=0;
			int n2=1;
			int n3=0;
			list1.add(n1);
			list1.add(n2);
			int count=val-2;
			while(count >0) {
				n3=n1+n2;
				list1.add(n3);
				n1=n2;
				n2=n3;
				count--;
			}
			System.out.println(list);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
