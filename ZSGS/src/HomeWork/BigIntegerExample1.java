package HomeWork;

import java.math.BigInteger;

public class BigIntegerExample1 {

	public static void main(String[] args) {

		Object obj="99988877766655443322111";
		BigInteger in=new BigInteger("99988877766655443322111");
		System.out.println(9999999999l);
		System.out.println("Big Integer : "+in);
		System.out.println("Object : "+obj);
		
		StringBuilder builder=new StringBuilder();
		int i=8;
		while(i > 0) {
			builder.append(i % 2);
			i/=2;
		}
		builder.reverse();
		System.out.println("Binary value : "+builder);
		builder.reverse();
		int sum=0;
		for(int j=0;j<builder.length();j++) {
			sum=sum+(Character.getNumericValue(builder.charAt(j)) * (int)Math.pow(2,j));
		}
		System.out.println("Decimal value : "+sum);
	

		
	}

}
