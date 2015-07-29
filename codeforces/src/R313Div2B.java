import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class R313Div2B {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int a1=in.nextInt();
		int b1=in.nextInt();
		int a2=in.nextInt();
		int b2=in.nextInt();
		int a3=in.nextInt();
		int b3=in.nextInt();
		
		int[][] x={{a1,b1},{b1,a1}};
		
		int[][] y={{a2+a3,Math.max(b2,b3)},{a2+b3,Math.max(b2,a3)},{b2+a3,Math.max(a2,b3)},{b2+b3,Math.max(a2,a3)}};
		
		for(int i=0;i<y.length;i++)
			for(int j=0;j<x.length;j++)
				if(y[i][0]<=x[j][0]&&y[i][1]<=x[j][1]){
					System.out.println("YES");
					return;
				}
		
		System.out.println("NO");
		
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
