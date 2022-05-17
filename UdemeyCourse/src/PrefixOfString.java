import java.util.Scanner;

public class PrefixOfString {

	public static void main(String args[]) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the number of words ");
		int len=scanner.nextInt();
		String s1[]=new String[len];
		System.out.println("Enter the words");
		for(int i=0;i<len;i++) {
			s1[i]=scanner.next();
		}
		prefixOfWords(s1);
	}

	private static void prefixOfWords(String[] s1) {
			String temp=new String();
			String result=new String();
			for(int i=1;i<s1.length;i++) {
				for(int j=1;j<s1.length;j++) {
					if(s1[0].substring(0,j).equals(s1[i].substring(0, j))){
						temp=s1[0].substring(0, j);
						if(temp.length()>result.length()) {
							result=temp;
						}
					}
				}
			}
						System.out.println("prefix : "+result);
			
	}

}
