import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class R317Div2A {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int na=in.nextInt();
		int nb=in.nextInt();
		int k=in.nextInt();
		int m=in.nextInt();
		int[] a=new int[na];
		for(int i=0;i<na;i++)
			a[i]=in.nextInt();
		int[] b=new int[nb];
		for(int i=0;i<nb;i++)
			b[i]=in.nextInt();
		if(a[k-1]<b[nb-m])
			System.out.println("YES");
		else
			System.out.println("NO");
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
