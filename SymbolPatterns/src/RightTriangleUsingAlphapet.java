
public class RightTriangleUsingAlphapet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char alphapet='A',last='E';
		for(int i=0; i<= last - 'A' ;i++) {
			for(int j=(last -'A' -i );j>=0;j--) {
				System.out.print(" ");	
			}
			for(int j=0;j<=i;j++) {
				System.out.print(alphapet);
			}
			alphapet++;
			System.out.println();
		}

	}

}
