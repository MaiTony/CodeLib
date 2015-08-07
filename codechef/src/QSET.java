import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
//Segment Tree
public class QSET {
	static class Node{
		long[] left=new long[3];
		long[] right=new long[3];
		int total=0;
		long cnt=0;
	}
	static int N,M;
	static char[] A;
	static Node[] tree=new Node[1<<18];
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		N=in.nextInt();
		M=in.nextInt();
		A=in.nextToken().toCharArray();
		build(1,0,N-1);
		while(M-->0){
			int type,X,Y,C,D;
			type=in.nextInt();
			if(type==1){
				X=in.nextInt();
				Y=in.nextInt();
				update(1,0,N-1,X-1,Y);
			}else{
				C=in.nextInt();
				D=in.nextInt();
				out.println(query(1,0,N-1,C-1,D-1).cnt);
			}
		}
		out.flush();
	}
	static Node query(int node,int a,int b,int i,int j){
		if(a>b||a>j||b<i)
			return new Node();
		if(a>=i&&b<=j)
			return tree[node];
		Node q1=query(node*2,a,(a+b)/2,i,j);
		Node q2=query(node*2+1,(a+b)/2+1,b,i,j);
		return merge(q1,q2);
	}
	static void update(int node,int a,int b,int i,int value){
		if(a>b||a>i||b<i)
			return;
		if(a==b){
			assign(node,value%3);
			return;
		}
		update(node*2,a,(a+b)/2,i,value);
		update(node*2+1,(a+b)/2+1,b,i,value);
		tree[node]=merge(tree[node*2],tree[node*2+1]);
	}
	static void build(int node,int a,int b){
		if(a>b) return;
		if(a==b){
			assign(node,(A[a]-'0')%3);
			return;
		}
		build(node*2,a,(a+b)/2);
		build(node*2+1,(a+b)/2+1,b);
		tree[node]=merge(tree[node*2],tree[node*2+1]);
	}
	static Node merge(Node a,Node b){
		Node ret=new Node();
		ret.cnt=a.cnt+b.cnt;
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				if((i+j)%3==0)
					ret.cnt+=a.right[i]*b.left[j];
		for(int i=0;i<3;i++){
			ret.left[i]=a.left[i]+b.left[(6-a.total+i)%3];
			ret.right[i]=b.right[i]+a.right[(6-b.total+i)%3];
		}
		ret.total=(a.total+b.total)%3;
		return ret;
	}
	static void assign(int node,int p){
		tree[node]=new Node();
		tree[node].left[p]=1;
		tree[node].right[p]=1;
		tree[node].total=p;
		if(p==0)
			tree[node].cnt=1;
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
