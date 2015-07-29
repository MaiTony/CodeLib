import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class R313Div2C {
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int a=in.nextInt();
		int b=in.nextInt();
		int c=in.nextInt();
		int d=in.nextInt();
		int e=in.nextInt();
		int f=in.nextInt();
		System.out.println((a+b+c)*(a+b+c)-a*a-c*c-e*e);
		
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
