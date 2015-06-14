package spoj;
/**
 * Binary Search
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AGGRCOW {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int i,j,t,n,c;
		long[] d;
		t=in.nextInt();
		for(i=0;i<t;i++){
			n=in.nextInt();
			c=in.nextInt();
			d=new long[n];
			for(j=0;j<n;j++){
				d[j]=in.nextLong();
			}
			Arrays.sort(d);
			if(c==2){
				out.println(d[n-1]-d[0]);
			}else{
				long mid=0,lo=0,hi=d[n-1]-d[0];
				int cnt=0;
				long cur;
				while(lo<hi){
					mid=lo+(hi-lo+1)/2;
					cnt=1;
					cur=d[0];
					for(j=1;j<n;j++){
						if(d[j]-cur>=mid){
							cnt++;
							cur=d[j];
						}
					}
					if(cnt>=c){
						lo=mid;
					}else{
						hi=mid-1;
					}
				}
				out.println(lo);
			}
		}
		out.flush();
	}
	static class FastScanner{
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(){br = new BufferedReader(new InputStreamReader(System.in));}
		String nextToken(){
			while(st == null||!st.hasMoreElements()){
				try{st = new StringTokenizer(br.readLine());}catch(Exception e){}
			}
			return st.nextToken();
		}
		int nextInt(){return Integer.parseInt(nextToken());}
		long nextLong(){return Long.parseLong(nextToken());}
		double nextDouble(){return Double.parseDouble(nextToken());}
	}
}
