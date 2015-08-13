import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class R314Div2A {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int n=in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		for(int i=0;i<n;i++){
			if(i==0){
				out.println(Math.abs(a[i]-a[i+1])+" "+Math.abs(a[i]-a[n-1]));
			}else if(i==n-1){
				out.println(Math.abs(a[n-1]-a[n-2])+" "+Math.abs(a[n-1]-a[0]));
			}else{
				int min=Math.min(Math.abs(a[i]-a[i+1]),Math.abs(a[i]-a[i-1]));
				int max=Math.max(Math.abs(a[i]-a[0]),Math.abs(a[i]-a[n-1]));
				out.println(min+" "+max);
			}
		}
		out.flush();
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
