import java.util.ArrayList;
import java.util.Arrays;

public class QueenAttack2 {

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
		list.add(new ArrayList<Integer>(Arrays.asList(5,5)));
		list.add(new ArrayList<Integer>(Arrays.asList(4,2)));
		list.add(new ArrayList<Integer>(Arrays.asList(2,3)));
		int arr[][]=new int[5][5];
		for(ArrayList<Integer> obj : list) {
			arr[obj.get(0)-1][obj.get(1)-1] = 1;
		}
		
		// Queen position
		
		arr[3][2]=-1;
		
		printArray(arr);
		
		
	
	}

	private static void printArray(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[i][j]+ "\t");
			}
			System.out.println();
		}
		
	}

}
