import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class R306Div2B {
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int l=in.nextInt();
		int r=in.nextInt();
		int x=in.nextInt();
		int[] c=new int[n];
		for(int i=0;i<n;i++)
			c[i]=in.nextInt();
		Arrays.sort(c);
		
		int ans=0;
		for(int i=0;i<(1<<n);i++){
			int min=0;
			int max=0;
			int sum=0;
			int k=i;
			for(int j=0;j<n;j++){
				if(((k>>j)&1)==1){
					if(min==0)
						min=c[j];
					max=c[j];
					sum+=c[j];
				}
			}
			if(max-min>=x&&sum>=l&&sum<=r)
				ans++;
		}
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
