import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class R312Div2B {
	static final int MAXN=1000000;
	static class Node implements Comparable<Node>{
		int s=-1;
		int e=-1;
		int c=0;
		@Override
		public int compareTo(Node a) {
			if(this.c>a.c)
				return 1;
			else if(this.c<a.c)
				return -1;
			else{
				if(this.e-this.s>a.e-a.s)
					return -1;
				else if(this.e-this.s<a.e-a.s)
					return 1;
				else
					return 0;
			}
		}
	}
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
		}
		Node[] list=new Node[MAXN+1];
		for(int i=0;i<=MAXN;i++)
			list[i]=new Node();
		for(int i=0;i<n;i++){
			list[a[i]].c++;
			if(list[a[i]].s==-1)
				list[a[i]].s=i+1;
			list[a[i]].e=i+1;
		}
		Arrays.sort(list);
		System.out.println(list[MAXN].s+" "+list[MAXN].e);
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
