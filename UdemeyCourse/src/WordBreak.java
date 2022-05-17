import java.util.HashSet;
import java.util.Scanner;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		HashSet<String> hashSet=new HashSet<String>();
		System.out.println("Enter the length of Dictionary ");
		int len=scanner.nextInt();
		System.out.println("Enter the words for Dictionary");
		for(int i=0;i<len;i++) {
			hashSet.add(scanner.next());
		}
		//System.out.println(hashSet.toString());
		System.out.println("Enter the String");
		String s1 =new String();
		s1=scanner.next();
		System.out.println(wordBreak(hashSet,s1));;
		
	}

	private static boolean wordBreak(HashSet<String> hashSet, String s1) {
		// TODO Auto-generated method stub
		int size=s1.length();  //IMPORTANT
		//System.out.println(size);
		if (size == 0)
	        return true;
		for(int i=1;i<=size;i++) {
			if(hashSet.contains(s1.substring(0,i)) && wordBreak(hashSet, s1.substring(i, size))) {
				return true;
			}
		}
		return false;
		
	} 

}
