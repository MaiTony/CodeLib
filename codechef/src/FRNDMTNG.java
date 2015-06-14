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
			}else{
				double x1=0,x2=0,a1=0,a2=0;
				if(t1<T2){
					x1=T2-t1;
					a1=x1*x1*0.5;
					if(x1>T1){
						x1-=T1;
						a1-=x1*x1*0.5;
					}
				}
				if(t2<T1){
					x2=T1-t2;
					a2=x2*x2*0.5;
					if(x2>T2){
						x2-=T2;
						a2-=x2*x2*0.5;
					}
				}
				ans=(T1*T2-a1-a2)/(T1*T2);
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
