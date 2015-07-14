import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class LCKYST {
	public static void main(String[] args) {
		int[] map={1,
				4,
				4,
				16,
				16,
				64,
				64,
				256,
				256,
				1024,
				1024,
				4096,
				4096,
				16384,
				16384
			};
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int n=in.nextInt();
		for(int i=0;i<n;i++){
			int b=in.nextInt();
			int a=b;
			while(a%10==0){
				a/=10;
			}
			int five=0;
			while(a%5==0){
				a/=5;
				five++;
			}
			if(five==0)
				out.println(b);
			else{
				BigInteger c=BigInteger.valueOf(b);
				c=c.multiply(BigInteger.valueOf(map[five]));
				out.println(c.toString());
			}
		}
		out.flush();
	}
	static final BigInteger TEN=BigInteger.valueOf(10);
	static final BigInteger ZERO=BigInteger.valueOf(0);
	
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
