import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class R311Div2B {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		long w=in.nextLong();
		long[] a=new long[2*n];
		for(int i=0;i<2*n;i++)
			a[i]=in.nextLong();
		Arrays.sort(a);
		long b=a[0];
		long c=a[n];
		if(b*2<=c){
			if(b*3*n<=w){
				System.out.println(b*3*n);
			}else{
				System.out.println(w);
			}
		}else{
			if(c*1.5*n<=w){
				System.out.println(c*1.5*n);
			}else{
				System.out.println(w);
			}
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
