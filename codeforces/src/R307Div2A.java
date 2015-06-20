import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class R307Div2A {
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int n=in.nextInt();
		int[][] a=new int[n][3];
		for(int i=0;i<n;i++){
			a[i][0]=in.nextInt();
			a[i][1]=i;
		}
		Arrays.sort(a,new Cmp1());
		int ans=1;
		int cnt=1;
		a[n-1][2]=ans;
		for(int i=n-2;i>=0;i--){
			if(a[i][0]==a[i+1][0]){
				a[i][2]=ans;
				cnt++;
			}else{
				ans+=cnt;
				cnt=1;
				a[i][2]=ans;
			}
		}
		Arrays.sort(a,new Cmp2());
		for(int i=0;i<n;i++)
			out.print(a[i][2]+" ");
		out.flush();
	}
	static class Cmp1 implements Comparator<int[]>{
		@Override
		public int compare(int[] a, int[] b) {
			if(a[0]<b[0])
				return -1;
			else if(a[0]>b[0])
				return 1;
			else
				return 0;
		}
	}
	static class Cmp2 implements Comparator<int[]>{
		@Override
		public int compare(int[] a, int[] b) {
			if(a[1]<b[1])
				return -1;
			else if(a[1]>b[1])
				return 1;
			else
				return 0;
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
