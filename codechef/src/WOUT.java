import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WOUT {
	static long[] tree;
	static long[] lazy;
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int T=in.nextInt();
		while(T-->0){
			int N=in.nextInt();
			int H=in.nextInt();
			int MAXN=2*(int)Math.pow(2,(int)Math.ceil(Math.log(N)/Math.log(2)));
			tree=new long[MAXN];
			lazy=new long[MAXN];
			for(int i=0;i<N;i++){
				update(1,0,N-1,in.nextInt(),in.nextInt(),1);
			}
			long ans=Long.MAX_VALUE;
			for(int i=0;i<N-H+1;i++){
				long sum=query(1,0,N-1,i,i+H-1);
				ans=Math.min(ans,H*1L*N-sum);
				if(ans==0)
					break;
			}
			out.println(ans);
		}
		out.flush();
		
	}
	
	static void update(int node,int s,int e,int l,int r,long v){
		if(lazy[node]>0){
			tree[node]+=(e-s+1)*lazy[node];
			if(s!=e){
				lazy[node*2]+=lazy[node];
				lazy[node*2+1]+=lazy[node];
			}
			lazy[node]=0;
		}
	
		if(s>r||e<l)
			return;
		
		if(s>=l&&e<=r){
			tree[node]+=(e-s+1)*v;
			if(s!=e){ 
				lazy[node*2]+=v;
				lazy[node*2+1]+=v;
			}
			return;
		}
	
		update(node*2,s,(s+e)/2,l,r,v);
		update(node*2+1,(s+e)/2+1,e,l,r,v);
	
		tree[node]=tree[node*2]+tree[node*2+1];
	}
	
	static long query(int node,int s,int e,int l,int r){
		if(lazy[node]>0){
			tree[node]+=(e-s+1)*lazy[node];
			if(s!=e){
				lazy[node*2]+=lazy[node];
				lazy[node*2+1]+=lazy[node];
			}
			lazy[node]=0;
		}
	
		if(s>r||e<l)
			return 0;
		
		if(s>=l&&e<=r)
			return tree[node];
	
		long q1=query(node*2,s,(s+e)/2,l,r);
		long q2=query(node*2+1,(s+e)/2+1,e,l,r);
	
		return q1+q2;
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
