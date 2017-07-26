package javabase.lean.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyByBuffered {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader("1.txt"));
			bw = new BufferedWriter(new FileWriter("1_w.txt"));
			int v = 0;
			while((v = br.read()) != -1) {
				bw.write(v);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
			if(bw!=null) {
				bw.close();
			}
		}
	}
}
