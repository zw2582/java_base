package javabase.lean.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacter {

	public static void main(String[] args) throws IOException {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("1.txt");
			fw = new FileWriter("1_c.txt");
			
			int c;
			
			while((c = fr.read()) != -1) {
				fw.write(c);
			}
		} finally {
			if(fr != null) {
				fr.close();
			}
			if (fw != null) {
				fw.close();
			}
		}
	}
}
