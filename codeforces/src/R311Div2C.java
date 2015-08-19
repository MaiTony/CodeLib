import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class R311Div2C {
	static int MAXN=100000;
	static int MAXD=200;

	public static void main(String[] args) {
		
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
		}
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<MAXN+1;i++)
			list.add(new ArrayList<Integer>());
		int[] d=new int[MAXD+1];
		for(int i=0;i<n;i++){
			int cost=in.nextInt();
			d[cost]++;
			list.get(a[i]).add(cost);
		}
		
		int cnt=0,tot=n;
		long ans=Long.MAX_VALUE;
		for(int i=MAXN;i>=0;i--){
			int m=list.get(i).size();
			if(m==0) continue;
			int var=0;
			int aux=0;
			for(int j=0;j<m;j++){
				int tmp=list.get(i).get(j);
				d[tmp]--;
				var+=tmp;
			}
			int left=tot-(2*m-1);
			for(int j=1;j<d.length&&left>0;j++){
				aux+=Math.min(left,d[j])*j;
				left-=d[j];
			}
			ans=Math.min(ans,cnt+aux);
			cnt+=var;
			tot-=m;
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
