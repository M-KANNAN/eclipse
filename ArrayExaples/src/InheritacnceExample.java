
abstract class A{
//	A(){
//		this.m1();
//	}
	public void m1() {
		System.out.println("Parent");
	}
}
class B extends A{
	public void m1() {
		System.out.println("Child");
	}
}


public class InheritacnceExample {
	public static void main(String[] args) {
		
		B obj=new B();
		obj.m1();
		A obj1=new A() {
		};
		obj1.m1();
		
		
//		HashMap<String, String> hashMap=new LinkedHashMap<String, String>(0,2f);
//		hashMap.put("hai","Hello");
//		hashMap.put("HAi","Hello");
//		System.out.println(hashMap);
		

	}

}
