
import java.util.*;
public class ExaplesString{
	public static void main(String[] args) {
		String str="kiKIkikikiKIKIKIkikiKI";
		int j=0;
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<str.length();i=i+2){
		    list.add(str.substring(i, i+2));
		}
		int male=0;
		int female=0;
		System.out.println(list.toString());
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i).equals(list.get(i+1))) {
				list.remove(i);
				i--;
			}                 
		}
		System.out.println(list.toString());	
		for(int i=0;i<list.size();i++) {
			if(list.get(i).equals("KI")) {
				male++;
			}
			else {
				female++;
			}
		}
		System.out.println("Male : "+male+" Female : "+female);
	
		
	}
}
