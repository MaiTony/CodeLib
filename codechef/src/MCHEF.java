import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class MCHEF {
	static int[] tree,lazy;

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int T=in.nextInt();
		while(T-->0){
			int N=in.nextInt();
			int K=in.nextInt();
			int M=in.nextInt();
			int[] A=new int[N+1];
			for(int i=1;i<=N;i++)
				A[i]=in.nextInt();
			int MAXN=2*(int)Math.pow(2,(int)Math.ceil(Math.log(N)/Math.log(2)));
			
			tree=new int[MAXN];
			lazy=new int[MAXN];
			Arrays.fill(tree,Integer.MAX_VALUE);
			Arrays.fill(lazy,Integer.MAX_VALUE);
			int[] cost=new int[N+1];
			//Arrays.fill(cost,Integer.MAX_VALUE);
			
			//Node root = new Node(0, N-1);
			for(int i=0;i<M;i++){
				int L=in.nextInt()-1;
				int R=in.nextInt()-1;
				int C=in.nextInt();
				update(1,0,N-1,L,R,C);
				//root.update(L,R,C);
			}
			for(int i=0;i<N;i++){
				cost[i+1]=query(1,0,N-1,i,i);
				//cost[i+1]=root.read(i);
			}
			long[] dp=new long[K+1];
			long sum=0;
			for(int i=1;i<=N;i++){
				sum+=A[i];
				if(A[i]<0){
					for(int j=K;j>=cost[i];j--){
						dp[j]=Math.max(dp[j], dp[j-cost[i]]-A[i]);
					}
				}
			}
			out.println(sum+dp[K]);

		}
		out.flush();
	}

	static void update(int node,int a,int b,int i,int j,int value){
		if(lazy[node]!=Integer.MAX_VALUE) {
				tree[node]=tree[node]>lazy[node]?lazy[node]:tree[node];
			if(a!=b) {
				lazy[node*2]=lazy[node*2]>lazy[node]?lazy[node]:lazy[node*2];
				lazy[node*2+1]=lazy[node*2+1]>lazy[node]?lazy[node]:lazy[node*2+1];
			}
			lazy[node]=Integer.MAX_VALUE;
		}
		
		if(a>b||a>j||b<i)
			return;

		if(a>=i&&b<=j){
			tree[node]=tree[node]>value?value:tree[node];
			if(a!=b) {
				lazy[node*2]=lazy[node*2]>value?value:lazy[node*2];
				lazy[node*2+1]=lazy[node*2+1]>value?value:lazy[node*2+1];
			}
			return;
		}

		update(node*2,a,(a+b)/2,i,j,value);
		update(1+node*2,1+(a+b)/2,b,i,j,value);

		tree[node]=Math.min(tree[node*2],tree[node*2+1]);
	}

	static int query(int node,int a,int b,int i,int j){
		if(lazy[node]!=Integer.MAX_VALUE) {
			tree[node]=tree[node]>lazy[node]?lazy[node]:tree[node];
			if(a!=b) {
				lazy[node*2]=lazy[node*2]>lazy[node]?lazy[node]:lazy[node*2];
				lazy[node*2+1]=lazy[node*2+1]>lazy[node]?lazy[node]:lazy[node*2+1];
			}
			lazy[node]=Integer.MAX_VALUE;
		}
		
		if(a>b||a>j||b<i)
			return Integer.MAX_VALUE;

		if(a>=i&&b<=j)
			return tree[node];

		return Math.min(query(node*2,a,(a+b)/2,i,j),query(1+node*2,1+(a+b)/2,b,i,j));
	}
/*
	static class Node {
		final int from;
		final int to;
		final Node left;
		final Node right;
		int cost = 1000;

		Node(int from, int to) {
			this.from = from;
			this.to = to;
			if (from == to) {
				left = null;
				right = null;
			} else {
				int mid = (from + to) >> 1;
				left = new Node(from, mid);
				right = new Node(mid+1, to);
			}
		}

		void update(int L, int R, int C) {
			if (R < from || to < L) {
				// no-op
			} else if (L <= from && to <= R) {
				if (cost > C) {
					cost = C;
				}
			} else {
				left.update(L, R, C);
				right.update(L, R, C);
			}
		}

		int read(int index) {
			if (index < from || to < index) {
				return Integer.MAX_VALUE;
			} else if (index == from && index == to) {
				return cost;
			} else {
				return Math.min(cost, Math.min(left.read(index), right.read(index)));
			}
		}
	}
*/
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
