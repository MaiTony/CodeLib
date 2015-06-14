import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FRNDMTNG {
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int T=in.nextInt();
		while(T-->0){
			long T1=in.nextLong();
			long T2=in.nextLong();
			long t1=in.nextLong();
			long t2=in.nextLong();
			double ans;
			if(t1==0&&t2==0){
				ans=0;
			}else if(t1==0){
				if(Math.min(T2+t2,T1)-t2<=0)
					ans=0;
				else
					ans=(Math.min(T2+t2,T1)-t2)*1.0/T2;
			}else if(t2==0){
				if(Math.min(T1+t1,T2)-t1<=0)
					ans=0;
				else
					ans=(Math.min(T1+t1,T2)-t1)*1.0/T1;
			}else{
				ans=0;
			}
			out.println(String.format("%.6f",ans));
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
