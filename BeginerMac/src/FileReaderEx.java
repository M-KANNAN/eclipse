import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {

	public static void main(String[] args) {
		

		File file=new File("/Users/m.kannan/MINE/FileReaderExample.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		try {
			int count=0;
			FileReader fileReader=new  FileReader(file);
			int i;
			while((i=fileReader.read()) != -1) {
				
				System.out.println(i);
				if(i == 97) {
					count++;
				}
			}
			System.out.println(count);
			fileReader.close();

			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		

	}

}
