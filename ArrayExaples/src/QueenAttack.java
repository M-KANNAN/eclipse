import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueenAttack {

	public static void main(String[] args) {
		
		List<List<Integer>> obs = new ArrayList<List<Integer>>(); 
		obs.add(new ArrayList<Integer>());
		obs.get(0).add(0,5);
		obs.get(0).add(1,5); 
	//	obs.add(new ArrayList<Integer>(Arrays.asList(5,5)));
		obs.add(new ArrayList<Integer>(Arrays.asList(4,2)));
		obs.add(new ArrayList<Integer>(Arrays.asList(2,3)));
		//System.out.println(obs);
		int n = 5;int k = 3; int r_q = 4; int c_q = 3;
		
		int[][] obsArr = new int[n][n];
		
		for(List<Integer> i : obs)
		{
			obsArr[i.get(0)-1][i.get(1)-1] = 1;
		}
		int r = r_q-1;int c = c_q-1; 
		obsArr[r][c] = -1;
		int count = 0;
		/*for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(obsArr[i][j]+"\t");
			}
			System.out.println();
		}*/
		for(int i=c+1;i<n;i++) //right from queen
		{
			if(obsArr[r][i] == 1)
			{
				break;
			}count++;
		}
		for(int i=c-1;i>=0;i--)//left from queen
		{
			if(obsArr[r][i] == 1)
			{
				break;
			}count++;
		}
		for(int i=r-1;i>=0;i--)//top to queen
		{
			if(obsArr[i][c] == 1)
			{
				break;
			}count++;
		}
		for(int i=r+1;i<n;i++)//bottom to queen
		{
			if(obsArr[i][c] == 1)
			{
				break;
			}count++;
		}
		//Queen up left r increase, c decrease
		for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--)
		{
			if(obsArr[i][j] == 1)
			{
				break;
			}count++;
		}
		//Queen down right 
		for(int i=r+1,j=c+1;i<n && j<n;i++,j++)
		{
			if(obsArr[i][j] == 1)
			{
				break;
			}count++;
		}
		//Queen up right
		for(int i=r-1,j=c+1;i>=0 && j<n;i--,j++)
		{
			if(obsArr[i][j] == 1)
			{
				break;
			}count++;
		}
		//Queen down left
		for(int i=r+1,j=c-1;i<n && j>=0;i++,j--)
		{
			if(obsArr[i][j] == 1)
			{
				break;
			}count++;
		}
		System.out.println(count);

	}

}
