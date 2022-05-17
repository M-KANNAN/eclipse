
public class StaticBlockex {
	
	static {
		System.out.println("Static block");
	}
	{
		System.out.println("normal block");
	}
		

	
	
	public static void main(boolean a) {
		// TODO Auto-generated method stub
		System.out.println("Main Method by boolean");

	}
	public static void main(String a) {
		// TODO Auto-generated method stub
		System.out.println("Main Method by string");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main Method");
		//StaticBlockex blockex=new StaticBlockex();
		StaticBlockex.main(args);
		main(true);
		main("hai");

	}

}
