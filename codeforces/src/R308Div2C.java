import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class R308Div2C {
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int w=in.nextInt();
		int m=in.nextInt();
		if(solve(w,m))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	static boolean solve(int w,int m){
		return w<=3||m==1||trySolve(w,m-1)||trySolve(w,m)||trySolve(w,m+1);
	}
	static boolean trySolve(int w,int m){
		return m%w==0&&solve(w,m/w);
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
