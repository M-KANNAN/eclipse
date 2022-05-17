import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class FileEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file=new File("/Users/m.kannan/Library/Mobile Documents/com~apple~Pages/Documents/MummyTyping.pages");
		try {
			FileReader fileReader=new FileReader(file);

			while(fileReader !=null) {
				System.out.println();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
