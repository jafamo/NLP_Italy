package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class NLPFileReader {

	private BufferedReader reader;

	public ArrayList<String> readFile(String fileName){
		
		ArrayList<String> file = new ArrayList<String>();
		
		try {
			// 1. Open a reader stream
			this.reader = new BufferedReader(new FileReader(fileName));
			
			// 2. Read out the file headers
			this.reader.readLine();
			
			// 3. Read each line of the file
			String fileLine;
			while((fileLine = this.reader.readLine())!=null){
				file.add(fileLine);
			}
			// 3. Close the file
			this.reader.close();
		} catch (Exception e) {
			// 4. On Exception print error message
			System.out.println("Exeption: "+e.getMessage());
		}
		
		return file;
	}
}
