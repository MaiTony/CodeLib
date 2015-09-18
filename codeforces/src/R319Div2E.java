import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class R319Div2E {
	static class Point implements Comparable<Point>{
		int i,x,y,block;
		public Point(int i,int x,int y){
			this.i=i;
			this.x=x;
			this.y=y;
			this.block=x/1000;
		}
		@Override
		public int compareTo(Point o) {
			if (this.block<o.block) return -1;
			if(this.block>o.block) return 1;
			if(this.block%2==0){
				if(this.y<o.y)
					return -1;
				else
					return 1;
			}else{
				if(this.y<o.y)
					return 1;
				else
					return -1;
			}
		}
	}
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		Point[] p=new Point[n];
		for(int i=0;i<n;i++)
			p[i]=new Point(i+1,in.nextInt(),in.nextInt());
		Arrays.sort(p);
		PrintWriter out=new PrintWriter(System.out);
		for(int i=0;i<n;i++)
			out.print(p[i].i+" ");
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
