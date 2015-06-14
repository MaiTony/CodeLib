package ChinaNewGradTest2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class bayanA {
	
	public void run() throws Exception {
		String path = bayanA.class.getProtectionDomain().getCodeSource().getLocation().getPath() + bayanA.class.getPackage().toString().replace("package ", "") + "/";
		String in = path.substring(1) + "input.in";
		String out = path.substring(1) + "input.out";
		
		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		int T = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < T; i ++) {
			String a = reader.readLine();
			int n = a.length();
			StringBuffer b = new StringBuffer("");
			for (int j = n - 1; j >= 0; j --)
				b.append(a.charAt(j));
			
			System.out.println(b);
			writer.append(b + "\n");
		}
	
		reader.close();
		writer.flush();
		writer.close();
	}
	
	public static void main(String[] args) throws Exception {
		new bayanA().run();
	}

}
