import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file=new File("/Users/m.kannan/MINE/zohoClass/Java/Example3.txt");
		try {
			if(file.createNewFile()) {
				System.out.println("File Created"+file.getName());
			}
			else {
				System.out.println("File already found"+file.getName());
			}
			file.setWritable(false);
			file.setExecutable(false);
			file.setReadable(false);

			
			//Checking for permission
			System.out.println("Is readable : "+file.canRead());
			System.out.println("Is Executable : "+file.canExecute());
			System.out.println("Is Write : "+file.canWrite());
			
			//deleting
			System.out.println("Deleting : "+file.delete());
			
			FileWriter fileWriter=new FileWriter("/Users/m.kannan/MINE/zohoClass/Java/Example3.txt");
			fileWriter.write("Before setting file permissions");
			fileWriter.close();
			
			Scanner scanner=new Scanner(file);
			if(scanner.hasNextLine()) {
				String s1=scanner.nextLine();
				System.out.println("Data in the file : "+s1);
				scanner.close();
			}

			
			//trying to write a file
			fileWriter.write("After setting file permissions");
			fileWriter.close();
			
			
			if(scanner.hasNextLine()) {
				String s1=scanner.nextLine();
				System.out.println("Data in the file : "+s1);
			}
			
			
			
			//Reading the data using scanner class
			
		
			if(scanner.hasNextLine()) {
				String s1=scanner.nextLine();
				System.out.println("Data in the file : "+s1);
			}
			
			
					
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
