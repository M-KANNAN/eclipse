import java.util.*;
public class SequetialDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="123456789";
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the min : ");
		int min=scanner.nextInt();
		System.out.println("Enter the max :");
		int max=scanner.nextInt();
		List<Integer> list=new Stack<Integer>();
		for(int i=1;i<9;i++) {
			for(int j=0;j<str.length()-i;j++) {
				String temp=str.substring(j,i+j);
				int num=Integer.parseInt(temp);
				if(num>min && num<max) {
					list.add(num);
				}
			}
		}
		System.out.println(list.toString());
		
	}

}
