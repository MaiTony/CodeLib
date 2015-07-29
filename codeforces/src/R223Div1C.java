import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class R223Div1C {
	static char[] s;
	static class Node{
		int t,o,c;
	}
	static Node[] tree=new Node[(1<<21)+1];
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		s=in.nextToken().toCharArray();
		int n=s.length;
		for(int i=0;i<=(1<<21);i++)
			tree[i]=new Node();
		build(1,0,n-1);
		int m=in.nextInt();
		while(m-->0){
			int l=in.nextInt();
			int r=in.nextInt();
			out.println(query(l-1,r-1,1,0,n-1).t*2);
		}
		out.flush();
	}
	static Node query(int x,int y,int id,int l,int r){
		if(l>r||l>y||r<x)
			return new Node();
		if(x<=l&&r<=y)
			return tree[id];
		int mid=(l+r)/2;
		Node a=query(x,y,2*id,l,mid);
		Node b=query(x,y,2*id+1,mid+1,r);
		Node ret=new Node();
		int tmp=Math.min(a.o,b.c);
		ret.t=a.t+b.t+tmp;
		ret.o=a.o+b.o-tmp;
		ret.c=a.c+b.c-tmp;
		return ret;
	}
	static void build(int id,int l,int r){
		if(r==l){
			if(s[l]=='(')
				tree[id].o=1;
			else
				tree[id].c=1;
			return;
		}
		
		int mid=(l+r)/2;
		build(2*id,l,mid);
		build(2*id+1,mid+1,r);
		int tmp=Math.min(tree[2*id].o,tree[2*id+1].c);
		tree[id].t=tree[2*id].t+tree[2*id+1].t+tmp;
		tree[id].o=tree[2*id].o+tree[2*id+1].o-tmp;
		tree[id].c=tree[2*id].c+tree[2*id+1].c-tmp;
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
