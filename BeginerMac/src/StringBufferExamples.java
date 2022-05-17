import java.util.Scanner;

public class StringBufferExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer buffer1=new StringBuffer("Welcome");
		//StringBuffer buffer2="Welcome";
		
		//Get input from user we need a string
		String str=new String();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the String");
		str=scanner.nextLine();
		StringBuffer buffer3=new StringBuffer(str);
		//StringBuffer buffer4=str;
		System.out.println(buffer1+" "+buffer3);
		
		//StringBuffer to String
		//String str1=buffer1;
		String str1=buffer1.toString();
		
		//Inbuild methods of StringBuffer
		
		//append()
		
		StringBuffer buffer5=new StringBuffer();
		buffer5.append("Hai");
		System.out.println(buffer5);
		StringBuffer buffer6=new StringBuffer();
		System.out.println("Enter the String");
		buffer6.append(scanner.nextLine());
		System.out.println(buffer6);
		
		//insert()
		StringBuffer buffer7=new StringBuffer("Welcome");
		buffer7.insert(1,"hai");
		buffer7.insert(3,'e');
		buffer7.insert(6,45);
		buffer7.insert(10,3.0);
		buffer7.insert(11,1234567890l);
		System.out.println(buffer7);
		
		
		//replace()
		StringBuffer buffer8=new StringBuffer("Welcome");
		buffer8.replace(1, 4, "hello");
		System.out.println(buffer8);
		
		//delete()
		StringBuffer buffer9=new StringBuffer("Welcome");
		buffer9.delete(1, 4);
		System.out.println(buffer9);
		
		//reverse()
		StringBuffer buffer10=new StringBuffer("Welcome");
		buffer10.reverse();
		System.out.println(buffer10);
		
		//capacity()
		StringBuffer buffer11=new StringBuffer();
		System.out.println(buffer11.capacity());
		buffer11.append("HELLO");
		System.out.println(buffer11.capacity());
		buffer11.append("Welcome to India");
		System.out.println(buffer11.capacity());
		
		//ensureCapacity()
		StringBuffer buffer12=new StringBuffer();
		System.out.println(buffer12.capacity());
		buffer12.append("HELLO");
		System.out.println(buffer12.capacity());
		buffer12.append("Welcome to India");
		System.out.println(buffer12.capacity());
		buffer12.ensureCapacity(10);
		System.out.println(buffer12.capacity());
		buffer12.ensureCapacity(50);
		System.out.println(buffer12.capacity());
		
		//length()
		StringBuffer buffer13=new StringBuffer("HAI");
		System.out.println(buffer12.length());
		
		//charAt()
		StringBuffer buffer14=new StringBuffer("HAI");
		System.out.println(buffer14.charAt(2));
		
		//substring()
		StringBuffer buffer15=new StringBuffer("HAIHello");
		System.out.println(buffer15.substring(3));
		System.out.println(buffer15.substring(3,7));
		

	}

}
