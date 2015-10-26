import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class R322Div2A {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int a=in.nextInt();
		int b=in.nextInt();
		if(a==b){
			System.out.println(a+" 0");
		}else if(a>b){
			int c=a-b;
			System.out.println(b+" "+c/2);
		}else{
			int c=b-a;
			System.out.println(a+" "+c/2);
		}
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
