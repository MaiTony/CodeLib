import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class R313Div2A {
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) a[i]=in.nextInt();
		Arrays.sort(a);
		if(a[0]==1)
			System.out.println(-1);
		else
			System.out.println(1);
	}
	static class FastScanner{
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(){br=new BufferedReader(new InputStreamReader(System.in));}
		String nextToken(){
			while(st==null||!st.hasMoreElements())
				try{st=new StringTokenizer(br.readLine());}catch(Exception e){}
			return st.nextToken();
		}
		int nextInt(){return Integer.parseInt(nextToken());}
		long nextLong(){return Long.parseLong(nextToken());}
		double nextDouble(){return Double.parseDouble(nextToken());}
	}

}
