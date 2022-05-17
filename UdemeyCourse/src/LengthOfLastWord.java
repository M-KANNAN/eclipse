import java.util.Scanner;

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the String : ");
		String str=new String();
		str=scanner.nextLine();
		System.out.println(lengthOfLastWord(str));
		

	}

	private static int lengthOfLastWord(String str) {
		// TODO Auto-generated method stub
		int count=0;
		for(int j=str.length()-1;j>=0;j--) {
			if( str.charAt(j) != ' ') {
				count++;
			}
			else {
				if(count >0) {
					return count;
				}
				
			}
		}
		return count;
	}

}
