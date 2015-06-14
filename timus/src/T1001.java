package solved;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class T1001 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] buf = new char[1024 * 300];
		Arrays.fill(buf, ' ');
		br.read(buf);
		StringTokenizer st = new StringTokenizer(String.valueOf(buf).replaceAll("\\r|\\n", " "));
		ArrayList<Long> a = new ArrayList<Long>();
		while (st.hasMoreTokens()) {
			String x = st.nextToken().trim();
			if (!"".equals(x))
			a.add(Long.parseLong(x));
		}
		
		int n = a.size();
		for (int i = n - 1; i >= 0; i --)
			System.out.println(String.format("%.4f", Math.sqrt(a.get(i))));
	}

}
