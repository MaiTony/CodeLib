import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class R308Div2A {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int sum=0;
		while(n-->0){
			int x1=in.nextInt();
			int y1=in.nextInt();
			int x2=in.nextInt();
			int y2=in.nextInt();
			sum+=(y2-y1+1)*(x2-x1+1);
		}
		System.out.println(sum);
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
