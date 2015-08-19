import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DCGAME {
	static Pair[] cts;
	static int N;
	static class Pair implements Comparable<Pair>{
		protected long first,second;
		public Pair(long first,long second){
			this.first=first;
			this.second=second;
		}
		public int compareTo(Pair o) {
			if(this.first<o.first)
				return -1;
			if(this.first>o.first)
				return 1;
			if(this.second<o.second)
				return -1;
			if(this.second>o.second)
				return 1;
			return 0;
		}
	}
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		N=in.nextInt();
		int M=in.nextInt();
		int[] a=new int[N];
		for(int i=0;i<N;i++)
			a[i]=in.nextInt();
		
		int[] L=new int[N];
		int[] st=new int[N];
		st[0]=0;
		int p=0;
		L[0]=-1;
		for(int i=1;i<N;i++){
			while(p>-1&&a[st[p]]<a[i])
				p--;
			L[i]=p<0?-1:st[p];
			st[++p]=i;
		}
		int[] R=new int[N];
		st=new int[N];
		st[0]=N-1;
		p=0;
		R[N-1]=N;
		for(int i=N-2;i>=0;i--){
			while(p>-1&&a[st[p]]<=a[i])
				p--;
			R[i]=p<0?N:st[p];
			st[++p]=i;
		}
		cts=new Pair[N];
		for(int i=0;i<N;i++)
			cts[i]=new Pair(a[i],(R[i]-i)*1L*(i-L[i]));
		Arrays.sort(cts);
		
		for(int i=1;i<N;i++)
			cts[i].second+=cts[i-1].second;
		
		long ans;
		for(int i=0;i<M;i++){
			String c=in.nextToken();
			int k=in.nextInt();
			String x=in.nextToken();
			if(">".equals(c)){
				ans=N*1L*(N+1)/2-find(k);
			}else if("<".equals(c)){
				ans=find(k-1);
			}else{
				ans=find(k)-find(k-1);
			}
			if("D".equals(x)){
				if(ans%2==0)
					out.print("C");
				else
					out.print("D");
			}else{
				if(ans%2==0)
					out.print("D");
				else
					out.print("C");
			}
		}
		
		out.flush();
	}
	static long find(int k){
		if(k==0) return 0;
		int L=0,R=N-1;
		while(L<R){
			int M=L+(R-L)/2+1;
			if(cts[M].first<=k)
				L=M;
			else
				R=M-1;
		}
		if(cts[L].first<=k)
			return cts[L].second;
		return 0;
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
