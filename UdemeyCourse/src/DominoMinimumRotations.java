import java.util.*;
public class DominoMinimumRotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		int domino1[]=new int [6];
		int domino2[]=new int[6];
		System.out.println("Enter the dice number from 1 to 6 for domino1");
		for(int i=0;i<6;i++) {
			domino1[i]=scanner.nextInt();
		}
		System.out.println("Enter the dice number from 1 to 6 for domino2");
		for(int i=0;i<6;i++) {
			domino2[i]=scanner.nextInt();
		}
		int ans=-1;
		for(int i=1;i<=6;i++) {
			int currAns=helper(domino1,domino2,i);
			if(currAns != -1 && (ans !=-1 || ans<currAns)) {
				ans=currAns;
			}
			
		}
		System.out.println("Minimum domino rotation : "+ ans);

	}

	private static int helper(int[] domino1,int[] domino2,int val) {
		int ansTop=0;
		int ansBottom=0;
		for(int i=0;i<6;i++) {
			if(domino1[i] != val && domino2[i] != val) {
				return -1;
			}
			
			else if(domino1[i] != val) {
				ansTop++;
			}
			else if(domino2[i] != val) {
				ansBottom++;
			}
		}
		
		return Math.min(ansTop,ansBottom);
	}
	

}
