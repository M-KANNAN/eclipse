package Training;

import java.util.Scanner;

public class Program53 {

	static void printCharSeq(char c, int num) {
		while (num > 1) {
			System.out.print(c);
			num--;
		}
	}

void convert(String str) {
		char c[] = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			int val = 0;
			if ((c[i] >= '0' && c[i] <= '9')) {
				try {
					if (c[i + 1] >= '0' && c[i + 1] <= '9') {
						String a1 = String.valueOf(c[i] - 48);
						String a2 = String.valueOf(c[i + 1] - 48);
						val = Integer.parseInt(a1 + a2);
						printCharSeq(c[i - 1], val);
						i++;
					} else {
						val = c[i] - 48;
						printCharSeq(c[i - 1], val);
					}
				} catch (ArrayIndexOutOfBoundsException ex) {
					val = c[i] - 48;
					printCharSeq(c[i - 1], val);
				}
			} else {
				System.out.print(c[i]);
			}
		}
	}

	public static void main(String [] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the string :");
		String s1=scanner.next();
		Program53 obj=new Program53();
		obj.convert(s1);
		scanner.close();
	
	}



}
