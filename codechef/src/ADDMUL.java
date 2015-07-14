import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ADDMUL {
	static int MAX=262145;
	static int MOD=1_000_000_007;
	static int N,Q;
	static long[] A=new long[100001];
	static long[] tree=new long[MAX];
	static long[] lazyr=new long[MAX];
	static long[] lazya=new long[MAX];
	static long[] lazym=new long[MAX];

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		N=in.nextInt();
		Q=in.nextInt();
			
		for(int i=0;i<N;i++) A[i]=in.nextLong();
		
		build(1,0,N-1);
		
		int q,x,y,v=0;
		while(Q-->0){
			q=in.nextInt();
			x=in.nextInt()-1;
			y=in.nextInt()-1;
			if(q!=4) v=in.nextInt();
			
			if(q==1){
				update(1,0,N-1,x,y,v,q);
			}else if(q==2){
				update(1,0,N-1,x,y,v,q);
			}else if(q==3){
				update(1,0,N-1,x,y,v,q);
			}else if(q==4){
				out.println(query(1,0,N-1,x,y));
			}
		}
		out.flush();
	}
	static long getMod(long a){
		if(a>=MOD)
			a%=MOD;
		return a;
	}
	static void build(int node,int s,int e){
		if(s==e){
			tree[node]=A[s];
			lazya[node]=lazyr[node]=0;
			lazym[node]=1;
			return;
		}
		
		build(node*2,s,(s+e)/2);
		build(node*2+1,(s+e)/2+1,e);
		
		tree[node]=getMod(tree[node*2]+tree[node*2+1]);
		lazya[node]=lazyr[node]=0;
		lazym[node]=1;
	}

	static void update(int node,int s,int e,int l,int r,long v,int q){
		if(lazyr[node]>0){
			tree[node]=getMod(lazyr[node]*(e-s+1));
			if(s!=e){
				lazyr[node*2]=lazyr[node*2+1]=lazyr[node];
				lazya[node*2]=lazya[node*2+1]=0;
				lazym[node*2]=lazym[node*2+1]=1;
			}
			lazyr[node]=0;
		}
		if(lazya[node]!=0||lazym[node]!=1){
			tree[node]=getMod(tree[node]*lazym[node]);
			tree[node]=getMod(tree[node]+getMod((e-s+1)*lazya[node]));
			if(s!=e){
				lazym[node*2]=getMod(lazym[node*2]*lazym[node]);
				lazym[node*2+1]=getMod(lazym[node*2+1]*lazym[node]);
				lazya[node*2]=getMod(lazya[node*2]*lazym[node]);
				lazya[node*2+1]=getMod(lazya[node*2+1]*lazym[node]);
				lazya[node*2]=getMod(lazya[node*2]+lazya[node]);
				lazya[node*2+1]=getMod(lazya[node*2+1]+lazya[node]);
			}
			
			lazya[node]=0;
			lazym[node]=1;
		}
	
		if(s>r||e<l)
			return;

		if(s>=l&&e<=r){
			if(q==1){
				tree[node]=getMod(tree[node]+(getMod((e-s+1)*v)));
				if(s!=e){ 
					lazya[node*2]=getMod(lazya[node*2]+v);
					lazya[node*2+1]=getMod(lazya[node*2+1]+v);
				}
			}else if(q==2){
				tree[node]=getMod(tree[node]*v);
				if(s!=e){
					lazya[node*2]=getMod(lazya[node*2]*v);
					lazya[node*2+1]=getMod(lazya[node*2+1]*v);
					lazym[node*2]=getMod(lazym[node*2]*v);
					lazym[node*2+1]=getMod(lazym[node*2+1]*v);
				}
			}else if(q==3){
				tree[node]=getMod((e-s+1)*v);
				if(s!=e){
					lazyr[node*2]=lazyr[node*2+1]=v;
					lazya[node*2]=lazya[node*2+1]=0;
					lazym[node*2]=lazym[node*2+1]=1;
				}
			}
			return;
		}
	
		update(node*2,s,(s+e)/2,l,r,v,q);
		update(node*2+1,(s+e)/2+1,e,l,r,v,q);
	
		tree[node]=getMod(tree[node*2]+tree[node*2+1]);
	}
	
	static long query(int node,int s,int e,int l,int r){
		if(lazyr[node]>0){
			tree[node]=getMod(lazyr[node]*(e-s+1));
			if(s!=e){
				lazyr[node*2]=lazyr[node*2+1]=lazyr[node];
				lazya[node*2]=lazya[node*2+1]=0;
				lazym[node*2]=lazym[node*2+1]=1;
			}
			lazyr[node]=0;
		}
		if(lazya[node]!=0||lazym[node]!=1){
			tree[node]=getMod(tree[node]*lazym[node]);
			tree[node]=getMod(tree[node]+getMod((e-s+1)*lazya[node]));
			if(s!=e){
				lazym[node*2]=getMod(lazym[node*2]*lazym[node]);
				lazym[node*2+1]=getMod(lazym[node*2+1]*lazym[node]);
				lazya[node*2]=getMod(lazya[node*2]*lazym[node]);
				lazya[node*2+1]=getMod(lazya[node*2+1]*lazym[node]);
				lazya[node*2]=getMod(lazya[node*2]+lazya[node]);
				lazya[node*2+1]=getMod(lazya[node*2+1]+lazya[node]);
			}
			
			lazya[node]=0;
			lazym[node]=1;
		}
	
		if(s>r||e<l)
			return 0;
		
		if(s>=l&&e<=r)
			return tree[node];
	
		long q1=query(node*2,s,(s+e)/2,l,r);
		long q2=query(node*2+1,(s+e)/2+1,e,l,r);
	
		return getMod(q1+q2);
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