package Training;

public class Program8 {
	
	int count1=0;//will get memory each time when the instance is created  
	static int count2=0;//common for all objects 
	Program8(){  
		count1++;//incrementing value  
		System.out.println("non static variable : "+count1);  
		count2++;//incrementing value  
		System.out.println("static variable : "+count2);
		}  
		  

	public static void main(String[] args) {
		
		new Program8();
		new Program8();
		new Program8();
		
		
	}

}
