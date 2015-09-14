import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class R205Div2B {
	
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int n=in.nextInt();
		int[] b=new int[2*n];
		int[] cnt=new int[100];
		for(int i=0;i<2*n;i++){
			b[i]=in.nextInt();
			cnt[b[i]]++;
		}
		int[] g1=new int[100];
		int[] g2=new int[100];
		int[] ans=new int[2*n];
		int cnt1=0;
		int cnt2=0;
		boolean f=false;
		for(int i=0;i<2*n;i++){
			if(cnt[b[i]]%2==0){
				if(g1[b[i]]<g2[b[i]]){
					ans[i]=1;
					g1[b[i]]++;
					cnt1++;
				}else{
					ans[i]=2;
					g2[b[i]]++;
					cnt2++;
				}
			}else{
				if(cnt[b[i]]>2){
					if(g1[b[i]]+g2[b[i]]<cnt[b[i]]-1){
						if(g1[b[i]]<g2[b[i]]){
							ans[i]=1;
							g1[b[i]]++;
							cnt1++;
						}else{
							ans[i]=2;
							g2[b[i]]++;
							cnt2++;
						}
					}
				}else{
					if(f){
						ans[i]=1;
						cnt1++;
					}else{
						ans[i]=2;
						cnt2++;
					}
					f=!f;
				}
			}
		}
		if(cnt1+cnt2<2*n){
			if(cnt1<=cnt2){
				for(int i=0;i<2*n&&cnt1<n;i++)
					if(ans[i]==0){
						ans[i]=1;
						cnt1++;
					}
				for(int i=0;i<2*n;i++)
					if(ans[i]==0)
						ans[i]=2;
			}else{
				for(int i=0;i<2*n&&cnt2<n;i++)
					if(ans[i]==0){
						ans[i]=2;
						cnt2++;
					}
				for(int i=0;i<2*n;i++)
					if(ans[i]==0)
						ans[i]=1;
			}
		}
		
		HashSet<Integer> h1=new HashSet<Integer>();
		HashSet<Integer> h2=new HashSet<Integer>();
		for(int i=0;i<2*n;i++)
			if(ans[i]==1)
				h1.add(b[i]);
			else
				h2.add(b[i]);
		out.println(h1.size()*h2.size());
		for(int i=0;i<2*n;i++)
			out.print(ans[i]+" ");
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
