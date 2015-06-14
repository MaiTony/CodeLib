package Test;
import java.util.Arrays;
import java.util.TreeMap;


public class Test4 {
	public static final String[] S = {
		"tarp", "given", "score", "refund", "only", "trap", "work", "earn", "course", "pepper", "part"};
	
	public void find(String s) {
		TreeMap<String, String> m = new TreeMap<String, String>();
		
		for (String k : S) {
			char[] c = k.toCharArray();
			Arrays.sort(c);
			m.put(k, String.valueOf(c));
		}
		
		char[] c = s.toCharArray();
		Arrays.sort(c);
		boolean f = true;
		for (String k : m.keySet()) {
			if (String.valueOf(c).equals(m.get(k))) {
				if (f) {
					f = !f;
					System.out.print(k);
				} else {
					System.out.print(" " + k);
				}
			}
		}
		if (f) {
			System.out.println(":(");
		} else {
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		Test4 t = new Test4();
		
		String s0 = "resco";
		String s1 = "nfudre";
		String s2 = "aptr";
		String s3 = "sett";
		String s4 = "oresuc";
		
		t.find(s0);
		t.find(s1);
		t.find(s2);
		t.find(s3);
		t.find(s4);
		
	}

}
