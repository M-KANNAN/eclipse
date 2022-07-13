package InterviewForDheena;

import java.util.HashMap;

public class One {
	
	HashMap<String, Two> hashMap=new HashMap<String, Two>();
	String s1;

	public One(String string, Two two) {
		this.hashMap.put(string, two);
		
	}

}
