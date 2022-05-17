import java.util.Scanner;

public class StockBuyandSellProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the stock buying value ");
		int stocks[]=new int[5];
		for(int i=0;i<5;i++) {
			stocks[i]=scanner.nextInt();
		}
		
		int currentValue=0;
		int maximumProfit=0;
		
		for(int i=0;i<5;i++) {
			for(int j=i+1;j<5;j++) {
				currentValue=stocks[j];
				if(currentValue>stocks[i]) {
					if(currentValue-stocks[i] > maximumProfit) {
						maximumProfit=currentValue-stocks[i];
					}
				}
			}
		}
		System.out.println("The maximum profit by selling the given stock is : "+maximumProfit);

	}

}
