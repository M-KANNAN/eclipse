import java.util.Scanner;

public class Qustion1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
		// 12345 - YES
		// 1245 - NO
		
		String s1=new String();
		System.out.println("enter the string:");
		s1=scanner.next();
		int len=s1.length();
		char a[]=new char[len];
		int j=0,i,value=0;
		int flag=0;
		for( i=0;i<s1.length();i++) {
			a[i]=s1.charAt(i);
		}
		for(j=0;j<len;j++) {
			System.out.println(a[j]);
		}
		for(i=0;i<len-1;i++) {
			
			value=a[i];
		//	System.out.println("value : "+value);  => ASCII COMPRISION used here
			if(a[i+1]==value+1||a[i+1]==value-1) {
				flag=0;
			}
			else {
				flag=1;
				break;
			}
			
		}
		if(flag==0) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		
		}
	}

}
