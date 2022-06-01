
public class QueenAttack2 {

	public static void main(String[] args) {
		
		int arr[][] = new int[8][8];
		arr[3][3]=1;
		int count=0;
		for(int i=0;i<8;i++) { // ROW
			if(arr[3][i] == 0) {
				count++;
			}
			else if(arr[i][i] == 1) {
				continue;
			}
			else {
				break;
			}
		}
		System.out.println(count);
		for(int i=0;i<8;i++) {   // column
			if(arr[i][3] == 0) {
				count++;
			}
			else if(arr[i][i] == 1) {
				continue;
			}
			else {
				break;
			}
		}
		System.out.println(count);
		
		for(int i=0;i<8;i++) {   // first diagonal
			if(arr[i][i] == 0) {
				count++;
			}
			else if(arr[i][i] == 1) {
				continue;
			}
			else {
				break;
			}
		}
		System.out.println(count);
		
		for(int i=0;i<8;i++) {   // first diagonal
			if(arr[i][7-i] == 0) {
				count++;
			}
			else if(arr[i][i] == 1) {
				continue;
			}
			else {
				break;
			}
		}
		
		System.out.println(count);

	}

}
