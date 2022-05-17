
public class FibinacieeSeries {
	//FIBINOCIEE SERIES USING RECURIVE FUNCTION
	
	static int n1=0,n2=1,n3=0;
	public void printFibinaciee(int count) {
		if(count>0) {
			n3=n1+n2;
			n1=n2;
			n2=n3;
			System.out.print(" "+n3);
			printFibinaciee(count-1);
		}
		
		
		
	}

	public static void main(String[] args) {
		System.out.print(n1+" "+n2);
		FibinacieeSeries fibinacieeSeries=new FibinacieeSeries();
		int count=10;
		fibinacieeSeries.printFibinaciee(count-2);
		
		
		
	}

}
