import java.util.Scanner;

public class SimplePalindromeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String s1=new String();
	        Scanner scanner=new Scanner(System.in);
	        System.out.println("Enter the string");
	        s1=scanner.next();
	        int len=s1.length();
	        int i=0;
	        int j=len-1;
	        int flag=0;
	        while(i<j){
	            if(s1.charAt(i)==s1.charAt(j)){
	                flag=0;
	            }
	            else{
	                flag=1;
	                break;
	            }
	            i++;
	            j--;
	        }
	        if(flag==0){
	            System.out.println("Pallindrome");
	        }
	        else{
	            System.out.println("Not a pallindrome");
	        }

	}

}
