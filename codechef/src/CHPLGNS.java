import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CHPLGNS {
	static class Point{
		int x, y;
		public Point(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
	static class Area{
		long area;
		int i;
	}
	static class Cmp implements Comparator<Area>{
		@Override
		public int compare(Area a,Area b){
			if(a.area<b.area)
				return -1;
			if(a.area>b.area)
				return 1;

			return 0;
		}
	}
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int T=in.nextInt();
		while(T-->0){
			int N=in.nextInt();
			Area[] area=new Area[N];
			for(int i=0;i<N;i++){
				int M=in.nextInt();
				Point[] p=new Point[M];
				for(int j=0;j<M;j++)
					p[j]=new Point(in.nextInt(),in.nextInt());
				
				area[i]=new Area();
				area[i].i=i;
				for(int j=0;j<M;j++)
					area[i].area+=p[j].x*1L*p[(j+1)%M].y-p[(j+1)%M].x*1L*p[j].y;
					//area[i].area+=(p[(j+1)%M].x+p[j].x)*1L*(p[(j+1)%M].y-p[j].y);
				area[i].area=Math.abs(area[i].area);
			}
			Arrays.sort(area,new Cmp());
			int[] ans=new int[N];
			for(int i=0;i<N;i++)
				ans[area[i].i]=i;
			
			for(int i=0;i<N;i++)
				out.print(ans[i]+" ");
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
