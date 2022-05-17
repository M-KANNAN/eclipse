import java.util.*;
public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner scanner=new Scanner(System.in);
		    System.out.println("Enter the length");
		    int len=scanner.nextInt();
		    System.out.println("Enter the amount of gas in each station");
		    int gas[]=new int[len];
		    for(int i=0;i<len;i++){
		       gas[i]=scanner.nextInt();
		    }
		    System.out.println("enter the cost to reach the next Station");
		    int cost[]=new int[len];
		    for(int i=0;i<len;i++){
		       cost[i]=scanner.nextInt();
		    }
		    int value=gasStation(gas,cost);
		    System.out.println(value);

	}

	private static int gasStation(int[] gas, int[] cost) {
		// TODO Auto-generated method stub
		
		int current=0;
	    int pos=0;
	    int diff=0;
	    int total=0;
	    for(int i=0;i<gas.length;i++){
	        diff=gas[i]-cost[i];
	        current+=diff;
	        total+=current;
	        if(current <0){
	            current=0;
	            pos=i;
	             }
	        }
	       if(total >=0){
	            return pos+1; 
	    }
	    else{
	        return -1;
	    }
	}

}
