package Round1A_2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class B {

	public static void main(String[] args) throws Exception {
		String path = B.class.getProtectionDomain().getCodeSource().getLocation().getPath() + A.class.getPackage().toString().replace("package ", "") + "/";
		String in = path.substring(1) + "input.in";
		String out = path.substring(1) + "input.out";
		
		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		int i, T = Integer.parseInt(reader.readLine());
		//String[] t;
		
		for (i= 0; i < T; i ++) {
			//t = reader.readLine().split(" ");
		}
		
		
		
		reader.close();
		writer.flush();
		writer.close();
	}

}
