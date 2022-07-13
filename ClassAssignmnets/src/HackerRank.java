
public class HackerRank {

	public static void main(String[] args) {
		
		String s = "99910001001";//91011  99910001001
		int len = s.length();
		String subStr = "";
		boolean valid = false;
		for(int i=1;i<=len/2;i++)
		{
			subStr = s.substring(0, i); 
			//System.out.println(subStr);
			Long num = Long.parseLong(subStr); 
			
			//System.out.println(num);
			String validStr = subStr;     
			while(validStr.length() < s.length())
			{
				validStr += Long.toString(++num);
				
			}
			if(s.equals(validStr))
			{
				valid = true; 
				break;
			}
		}
		if(valid == true)
			System.out.println("YES "+subStr);
		else
			System.out.println("NO");

	}

}
