import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class R321Div2A {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) a[i]=in.nextInt();
		int max=1;
		int pre=a[0];
		int ans=0;
		for(int i=1;i<n;i++){
			if(a[i]>=pre){
				max++;
				pre=a[i];
			}else{
				ans=Math.max(ans,max);
				max=1;
				pre=a[i];
			}
		}
		ans=Math.max(ans,max);
		System.out.println(ans);
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
