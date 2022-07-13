import java.util.Scanner;

public class HuffmanDecoder {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the decoding string ");
		String s1=scanner.next();
		StringBuilder buider=new StringBuilder();
		for(int i=0;i<s1.length();) {
			if(s1.charAt(i) == '0') {
				buider.append("A");
				i=i+1;
			}
			else if(s1.subSequence(i, i+2).equals("10")) {
				buider.append("B");
				i=i+2;
			}
			else if(s1.subSequence(i, i+3).equals("110")) {
				buider.append("C");
				i=i+3;
			}
			else if(s1.subSequence(i, i+4).equals("1110")) {
				buider.append("D");
				i=i+4;
			}
			else if(s1.subSequence(i, i+4).equals("1111")) {
				buider.append("E");
				i=i+4;
			}
			else {
				System.out.println("Wrong code");
				break;
			}
		}
		System.out.println(buider.toString());
		
	}

}
