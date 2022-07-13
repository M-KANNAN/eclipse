package Interview;



class One{
	One(){ 
		this(5);
		System.out.println("parent default constructor");
	}
	One(int i){
		System.out.println("parent parameterized constructor");
	}
}
class Two extends One{
	Two(){
		super();
		System.out.println("child default constructor");
	}
	Two(int i){
		this();
		System.out.println("child parameterized constructor");
		
	}
}

public class Question5 {
	

	public static void main(String[] args) {
		
		Two two=new Two(5);
		
	}

}
