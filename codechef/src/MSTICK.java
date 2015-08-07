import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
//Segment Tree
public class MSTICK {
	static int N,Q;
	static int[] minTree=new int[1<<18];
	static int[] maxTree=new int[1<<18];
	static int[] b;
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		N=in.nextInt();
		b=new int[N];
		for(int i=0;i<N;i++)
			b[i]=in.nextInt();
		Arrays.fill(minTree,Integer.MAX_VALUE);
		build(1,0,N-1);
		Q=in.nextInt();
		while(Q-->0){
			int L=in.nextInt();
			int R=in.nextInt();
			int min=minQuery(1,0,N-1,L,R);
			int maxL=0,maxM,maxR=0;
			maxM=maxQuery(1,0,N-1,L,R);
			if(L>0)
				maxL=maxQuery(1,0,N-1,0,L-1);
			if(R<N-1)
				maxR=maxQuery(1,0,N-1,R+1,N-1);
			
			out.println(String.format("%.1f",Math.max(Math.max(min+maxL,min+maxR),(maxM-min)/2.0+min)));
		}
		
		out.flush();
	}
	static int minQuery(int node,int s,int e,int l,int r){
		if(s>e||s>r||e<l)
			return Integer.MAX_VALUE;
		if(s>=l&&e<=r)
			return minTree[node];
		return Math.min(minQuery(node*2,s,(s+e)/2,l,r),minQuery(node*2+1,(s+e)/2+1,e,l,r)); 
	}
	static int maxQuery(int node,int s,int e,int l,int r){
		if(s>e||s>r||e<l)
			return 0;
		if(s>=l&&e<=r)
			return maxTree[node];
		return Math.max(maxQuery(node*2,s,(s+e)/2,l,r),maxQuery(node*2+1,(s+e)/2+1,e,l,r)); 
	}
	static void build(int node,int s,int e){
		if(s>e)
			return;
		if(s==e){
			minTree[node]=b[s];
			maxTree[node]=b[s];
			return;
		}
		build(node*2,s,(s+e)/2);
		build(node*2+1,(s+e)/2+1,e);
		minTree[node]=Math.min(minTree[node*2],minTree[node*2+1]);
		maxTree[node]=Math.max(maxTree[node*2],maxTree[node*2+1]);
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
