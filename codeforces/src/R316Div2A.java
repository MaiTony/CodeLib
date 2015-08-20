import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class R316Div2A {
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int m=in.nextInt();
		int[] ans=new int[n];
		for(int i=0;i<m;i++){
			int idx=0;
			int max=0;
			for(int j=0;j<n;j++){
				int a=in.nextInt();
				if(max<a){
					max=a;
					idx=j;
				}
			}
			ans[idx]++;
		}
		int res=0;
		int max=0;
		for(int i=0;i<n;i++){
			if(max<ans[i]){
				max=ans[i];
				res=i+1;
			}
		}
		System.out.println(res);
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
