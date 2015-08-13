import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class R314Div2B {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		String[] a=new String[n];
		String[] b=new String[n];
		for(int i=0;i<n;i++){
			a[i]=in.nextToken();
			b[i]=in.nextToken();
		}
		HashSet<String> x=new HashSet<String>();
		int r=0,maxr=0;
		for(int i=0;i<n;i++){
			if("+".equals(a[i])){
				if(r==0){
					r=1;
					maxr++;
				}
				r--;
				x.add(b[i]);
			}else{
				r++;
				if(!x.contains(b[i]))
					maxr++;
			}
		}
		System.out.println(maxr);
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
