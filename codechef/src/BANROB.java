import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BANROB {
	static double MAX=1000000000;
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int T=in.nextInt();
		while(T-->0){
			int M=in.nextInt();
			double p=in.nextDouble();
			
			double s1=MAX*(pow(-p,M)-1)/(-p-1);
			double s2=MAX-s1;
			out.println(String.format("%.2f",s1)+" "+String.format("%.2f",s2));
		}
		out.flush();
	}
	static double pow(double p,int m){
		if(m==0)
			return 1;
		if(m==1)
			return p;
		if(m%2==0)
			return pow(p*p,m/2);
		else
			return p*pow(p*p,m/2);
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
