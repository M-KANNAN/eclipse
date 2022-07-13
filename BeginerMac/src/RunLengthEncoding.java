
public class RunLengthEncoding {

	public static void main(String[] args) {
		
		String s1="a10b6c15";
		StringBuilder number=new StringBuilder();
		StringBuilder character=new StringBuilder();
		number.trimToSize();
		character.trimToSize();
		
		for(int i=0;i<s1.length();i++) {
			if(character.length() == 1 && Character.isAlphabetic(s1.charAt(i))) {
				for(int j=0;j<Integer.parseInt(number.toString());j++) {
					System.out.print(character);
				}
				character.setLength(0);
				number.setLength(0);
				character.append(s1.charAt(i));
			}
			
			else if(Character.isDigit(s1.charAt(i))) {
				number.append(s1.charAt(i));
			}
			else if(Character.isAlphabetic(s1.charAt(i))) {
				character.append(s1.charAt(i));
			}
			if(i == s1.length() -1) {
				for(int j=0;j<Integer.parseInt(number.toString());j++) {
					System.out.print(character);
				}
			}
		}
		
	}

}
