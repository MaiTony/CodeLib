import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class R276Div2D {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		TreeSet<Integer> a=new TreeSet<Integer>();
		for(int i=0;i<n;i++){
			a.add(in.nextInt());
		}
		int res=0;
		int max=a.last();
		for(int b:a){
			for(int i=2*b;i<=max;i+=b){
				Integer x=a.lower(i);
				if(x!=null&&x>b)
					res=Math.max(res,x+b-i);
				if(res==b-1)
					break;
			}
			res=Math.max(res,max%b);
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
