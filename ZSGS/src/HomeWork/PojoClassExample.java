package HomeWork;

import java.util.Scanner;

class Pojo1{
	private long regNo;
	private String name;
	private String mobileNo;
	private byte age;
	private char gender;
	private String email;
	
	public long getRegNo() {
		return regNo;
	}
	public void setRegNo(long regNo) {
		this.regNo = regNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

public class PojoClassExample {

	public static void main(String[] args) {
		Scanner  scanner=new Scanner(System.in);
		System.out.println("Enter your register No :");
		long regNo=scanner.nextLong();
		System.out.println("Enter the name :");
		scanner.next();
		String name=scanner.nextLine();
		System.out.println("Enter your age :");
		byte age=scanner.nextByte();
		System.out.println("Enter your Mobile No :");
		String mobileNo=scanner.next();
		System.out.println("Enter your Gender as M for male and F for female :");
		char gender=scanner.next().charAt(0);
		System.out.println("Enter the Email :");
		scanner.next();
		String email=scanner.nextLine();
		
		System.out.println();
		System.out.println("Setting the  value in private instance of the pojo class");
		Pojo1 pojo1=new Pojo1();
		pojo1.setRegNo(regNo);
		pojo1.setName(name);
		pojo1.setAge(age);
		pojo1.setGender(gender);
		pojo1.setMobileNo(mobileNo);
		pojo1.setEmail(email);
		
		System.out.println();
		System.out.println("Getting the values from the private instance of the value");
		System.out.println();
		System.out.println("                           **Student Details**");
		System.out.println("               ~Register Number :"+pojo1.getRegNo());
		System.out.println("               ~Name  :"+pojo1.getName());
		System.out.println("               ~Age :"+pojo1.getAge());
		System.out.println("               ~Gender :"+pojo1.getGender());
		System.out.println("               ~Mobile No :"+pojo1.getMobileNo());
		System.out.println("               ~Email :"+pojo1.getEmail());
		
		

	}

}
