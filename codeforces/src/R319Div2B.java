import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class R319Div2B {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int m=in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) a[i]=in.nextInt();
		if(n>=m){
			System.out.println("YES");
		}else{
			boolean[][] dp=new boolean[2][m];
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					if(dp[i&1][j]){
						dp[(i+1)&1][(j+a[i])%m]=true;
						dp[(i+1)&1][j]=true;
					}
				}
				dp[(i+1)&1][a[i]%m]=true;
				if(dp[(i+1)&1][0]){
					System.out.println("YES");
					return;
				}
			}
			System.out.println("NO");
		}
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
