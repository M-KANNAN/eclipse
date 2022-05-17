import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class FileExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			File myFile=new File("/Users/m.kannan/MINE/zohoClass/java/FileExample.txt");
			if(myFile.createNewFile()) {
				System.out.println("File Created : "+ myFile.getName());
			}
			else {
				System.out.println("File already found "+ myFile.getName());
			}
			
			//File Methods
			
			System.out.println("File Exist or not by exist() method : "+myFile.exists());
			System.out.println("File can be writtable or not by canWrite() method : "+myFile.canWrite());
			System.out.println("File absolute path by getAbsolutePath() method : "+myFile.getAbsolutePath());
			System.out.println("File length by length() method : "+myFile.length());
			
			//After Deletion
			
			System.out.println("File deleted by delete() method : "+myFile.delete());
			System.out.println("File Exist or not by exist() method : "+myFile.exists());
			
			//After deletion create a new file
			if(myFile.createNewFile()) {
				System.out.println("File Created : "+ myFile.getName());
			}
			else {
				System.out.println("File already found "+ myFile.getName());
			}
			
			//Write a file using fileWritter
			
			FileWriter fileWriter=new FileWriter("/Users/m.kannan/MINE/zohoClass/java/FileExample.txt");
			fileWriter.write("My first java file example.");
			fileWriter.close();
			System.out.println("File writed Sucussfully");
			
			//Read file using scanner class using file object as argument
			//check the file has data or not by hasNextLine()
			//use string to store the data from the file using nextLine()
			
			Scanner scanner=new Scanner(myFile);
			if(scanner.hasNextLine()) {
				String data=scanner.nextLine();
				System.out.println("Data found in the file is : "+data);
			}
			scanner.close();
			
			
			
						
		}
		catch(IOException e ) {
			System.out.println("Error Occured");
			e.printStackTrace();
			
		}
		

	}

}
