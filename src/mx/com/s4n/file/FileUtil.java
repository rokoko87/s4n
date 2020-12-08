package mx.com.s4n.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * File method utils
 * @author alvazquez
 *
 */
public class FileUtil {
	
	public static final String OUT_FILE_PREFIX = "out";
	
	/**
	 * Read a file and get the deliveries instructions
	 * @param fileName File name
	 * @param result List of deliveryInstructions
	 * @throws IOException
	 */
	public static List<String> readFile (String fileName) throws FileNotFoundException, IOException{
		List<String> deliveries = new ArrayList<String>();
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		String linea = bf.readLine();
		while (linea != null && linea.length() > 0) {
			deliveries.add(linea);
			linea = bf.readLine();
		}
		bf.close();
		return deliveries;
	}
	
	/**
	 * Create a OutFile file given the inFile
	 * @param inFile InFile name
	 * @throws IOException
	 */
	public static void printResult (String inFile, String result) throws IOException {
		String outFileName = outNameFile(inFile);
		PrintWriter pw = new PrintWriter(new FileWriter(outFileName));
		pw.println(result);
		pw.close();
	}
	
	
	public static void printResults (String inFile, String[] results) throws IOException {
		String outFileName = outNameFile(inFile);
		PrintWriter pw = new PrintWriter(new FileWriter(outFileName));
		for (String result: results) {
			pw.println(result);
		}
		pw.close();
	}
	
	
	private static String outNameFile (String inNameFile) {
		String fileName = inNameFile.substring(2, inNameFile.length());
		return OUT_FILE_PREFIX + fileName;
	}

}
