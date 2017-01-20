import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * Note: The code below is written assuming that the given input text file does
 * not change. But if there are a series of input files for which the program will be run many
 * times, I can just create a filesys directory for each input file, with the same name as 
 * its respective input text file. Changing my code to handle this would be trivial.
 * 
 * 
 * Credit to Stack Overflow for much of the file and path manipulation code, via existing Java libraries.
 * 
 * @author Brian Ha
 * @version 1.0
 */
public class RandomLine {

	/**
	 * Every time randomLine is called, it checks whether a 'filesys' directory exists in the
	 * working directory. If so, it simply accesses the .txt file named appropriately with
	 * the given line number and prints out its contents.  Otherwise, randomLine will create the
	 * 'filesys' directory, go through every line in the input file, and create a file named after
	 * the current line number holding that line's contents.
	 * 
	 * @param path   the path of the input file
	 * @param index  the line number of the input file to be printed to standard output
	 */
	private static void randomLine(String path, int index) {
		BufferedReader br;	
		String dir = System.getProperty("user.dir"); // Gets working directory.
		dir += "\\filesys";
		Path dbPath = Paths.get(dir); // Creates Path object from String dir.
		
		if (!Files.exists(dbPath)) { // If the program is being run for the first time.
			File newDir = new File("filesys");
			newDir.mkdir();
			int currLineNum = 0;
			try{
				br = new BufferedReader(new FileReader(path));
				String line;
				while ((line = br.readLine()) != null) { // While another line exists in the input file.
					String currFilename = currLineNum + ".txt";
					File newFile = new File(newDir, currFilename);
					BufferedWriter outFile = new BufferedWriter(new FileWriter(newFile));
			        outFile.write(line);
			        outFile.close();
					currLineNum++;
				}	
			} catch (IOException e) {
				e.printStackTrace(); // This should never happen.
			}
		}
		
		dir = dir + "\\" + index + ".txt"; // Creates path to index .txt file.
		try {
			br = new BufferedReader(new FileReader(dir.toString()));
			String line = br.readLine(); // Only one line to read in every file.
			br.close();
			System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace(); // This should never happen.
		}
	}
	
	/**
	 * Main method used to test randomLine function. All calls after the first should be
	 * nearly instant.
	 * @param args  path of input file and line number in String array form
	 */
	public static void main(String[] args) {
		randomLine(args[0], Integer.parseInt(args[1]));
	}
}
