import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritterEx {

	public static void main(String[] args) {
		
		File file=new File("/Users/m.kannan/MINE/FileExample.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		try {
			FileWriter fileWriter=new FileWriter(file);
			for(int i=0;i<100;i++) {
				fileWriter.write(i+"\n");
			}
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
	
			e.printStackTrace();
		}		
	}
}