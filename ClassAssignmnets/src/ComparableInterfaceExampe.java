import java.util.ArrayList;
import java.util.Collections;

class Students implements Comparable<Students>{
	String s1;
	
	public Students(String string) {
		this.s1=string;
	}

	@Override
	public int compareTo(Students o1) {
		return this.s1.compareTo(o1.s1);
	}
	
}



public class ComparableInterfaceExampe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Students> arrayList=new ArrayList<Students>();
		
		arrayList.add(new Students("Kanna"));
		arrayList.add(new Students("Kanna"));
		arrayList.add(new Students("Robin"));
		arrayList.add(new Students("Abi"));
		
		Collections.sort(arrayList);	
		
		for(Students students : arrayList) {
			System.out.println(students.s1);
		}

	}

}
