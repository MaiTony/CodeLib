package ChinaNewGradTest2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class bayanB {
	
	public void run() throws Exception {
		String path = bayanB.class.getProtectionDomain().getCodeSource().getLocation().getPath() + bayanB.class.getPackage().toString().replace("package ", "") + "/";
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
			int sum = 0;
			for (int j = 0; j < n; j ++)
				if (a.charAt(j) == 'a' || a.charAt(j) == 'e' || a.charAt(j) == 'i' || a.charAt(j) == 'o' || a.charAt(j) == 'u')
					sum ++;
			
			System.out.println(sum % 2 == 1 ? "PESAR" : "DOKHTAR");
			writer.append(sum % 2 == 1 ? "PESAR\n" : "DOKHTAR\n");
		}
	
		reader.close();
		writer.flush();
		writer.close();
	}
	
	public static void main(String[] args) throws Exception {
		new bayanB().run();
	}

}
