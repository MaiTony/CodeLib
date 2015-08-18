import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class COOKMACH {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int T=in.nextInt();
		while(T-->0){
			int a=in.nextInt();
			int b=in.nextInt();
			if (a==b){
				out.println(0);
			}else{
				int bitcnt=0;
				int i=0;
				while((a>>i)>2){
					if(((a>>i)&1)>0)
						bitcnt=i+1;
					i++;
				}
				a>>=bitcnt;
				while(a>b){
					a>>=1;
					bitcnt++;
				}
				while(a<b){
					a<<=1;
					bitcnt++;
				}
				out.println(bitcnt);
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
