
public class DemoHacker {

	public static void main(String[] args) {
		int n=10;
		String s1="abcac";
		int count =0;
	    for(int i=0;i<s1.length();i++){
	    	
	        if(s1.charAt(i) == 'a'){
	   
	            for(int j=i;j<n;j=j+i){
	            	System.out.println(j);
	                count++;
	                
	            }
	        }
	    }
	    System.out.println(count);

	}

}
