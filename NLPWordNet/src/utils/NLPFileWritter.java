package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class NLPFileWritter {
	
	public void writeFile(String fileName, ArrayList<String> fileLines, String headers){
		
		try {
			//Open File
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			
			// Write Headers
			writer.write(headers);
			writer.newLine();
			
			//Iterate through lines
			for (String fileLine : fileLines) {
				//2.1. Write a line in the file
				writer.write(fileLine);
				//2.3. Write a new line in the file
				writer.newLine();
			}
			// Flush the buffer contents into the file
			writer.flush();
			
			// 4. Close File
			writer.close();
		} catch (Exception e) {
			// 4. On exception printout error message
			System.out.println("Exception: "+e.getMessage());
		}
		
	}
}
