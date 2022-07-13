import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class EmailAddressValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, String> hm=new HashMap<>(16,2.0f);
		
//		for(int i=1;i<10;i++) {
//			hm.put(i*16, ""+(i*16));
//		}
//		hm.put(1,"1");
//		System.out.println(hm);
		
		hm.put(0, null);
		hm.put(16, null);
		hm.put(32, null);
		hm.put(48, null);
		hm.put(64, null);
		hm.put(80, null);
		hm.put(96, null);
		hm.put(112, null);
		hm.put(128, null);
		hm.put(144, null);
		hm.put(160, null);
		hm.put(176, null);
		hm.put(192, null);
		hm.put(208, null);
//		hm.put(224, null);
//		hm.put(240, null);
//		hm.put(256, null);
//		hm.put(272, null);
//		hm.put(282, null);
		hm.put(1, null);
		
		
		
		System.out.println(hm);
		
				

	}
}