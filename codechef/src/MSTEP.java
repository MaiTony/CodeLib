import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MSTEP {
	static class Point{
		int x,y;
		public Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int T=in.nextInt();
		while(T-->0){
			int n=in.nextInt();
			HashMap<Integer,Point> map=new HashMap<Integer,Point>();
			for(int i=1;i<=n;i++){
				for(int j=1;j<=n;j++){
					map.put(in.nextInt(),new Point(i,j));
				}
			}
			int ans=0;
			for(int i=1;i<=n*n-1;i++){
				ans+=Math.abs(map.get(i).x-map.get(i+1).x)+Math.abs(map.get(i).y-map.get(i+1).y);
			}
			out.println(ans);
		}
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
