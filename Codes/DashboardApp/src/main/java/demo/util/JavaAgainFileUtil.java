package demo.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JavaAgainFileUtil {

	public static void main(String[] args) throws Exception {
		System.out.println(readFile("ok"));

	}

	public static String readFile(String filename) throws Exception {
		//filename = "src\\main\\java\\demo\\servlets\\ServletApp.java";
		InputStream is = new FileInputStream(filename);
		String output = "";
		if (is != null) {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);

			String text;
			while ((text = reader.readLine()) != null) {
				output = output + text + "</br>";
			}
			reader.close();
		}
		return output;

	}

}
