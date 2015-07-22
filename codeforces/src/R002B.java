import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class R002B {
	static int n;
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		n=in.nextInt();
		int[][] dp2=new int[n][n];
		int[][] dp5=new int[n][n];
		boolean foundzero=false;
		int zerox=0,zeroy=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int a=in.nextInt();
				if(a==0){
					foundzero=true;
					zerox=i;
					zeroy=j;
				}else{
					while(a%5==0){
						dp5[i][j]++;
						a/=5;
					}
					while(a%2==0){
						dp2[i][j]++;
						a/=2;
					}
				}
			}
		}
		search(dp2,2);
		search(dp5,5);
		int best=Math.min(foundzero?1:Integer.MAX_VALUE,Math.min(dp2[n-1][n-1],dp5[n-1][n-1]));
		out.println(best);
		if(best==1&&foundzero){
			for(int i=0;i<zerox;i++)
				out.print("D");
			for(int j=0;j<zeroy;j++)
				out.print("R");
			for(int i=0;i<n-zerox-1;i++)
				out.print("D");
			for(int j=0;j<n-zeroy-1;j++)
				out.print("R");
			out.println();
		}else if(best==dp5[n-1][n-1]){
			out.println(printPath(n-1,n-1,dp5));
		}else{
			out.println(printPath(n-1,n-1,dp2));
		}
		out.flush();
	}
	static StringBuffer printPath(int i,int j,int[][] dp){
		StringBuffer ret=new StringBuffer("");
		if(i==0){
			for(int m=0;m<j;m++)
				ret.append("R");
		}else if(j==0){
			for(int m=0;m<i;m++)
				ret.append("D");
		}else{
			if(dp[i][j-1]<=dp[i-1][j]){
				ret.append(printPath(i,j-1,dp));
				ret.append("R");
			}else{
				ret.append(printPath(i-1,j,dp));
				ret.append("D");
			}
		}
		return ret;
	}
	static void search(int[][] dp,int div){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==0&&j==0)
					continue;
				else if(i==0)
					dp[i][j]+=dp[i][j-1];
				else if(j==0)
					dp[i][j]+=dp[i-1][j];
				else
					dp[i][j]+=Math.min(dp[i][j-1],dp[i-1][j]);
			}
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