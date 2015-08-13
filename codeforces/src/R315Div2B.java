import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class R315Div2B {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int n=in.nextInt();
		TreeSet<Integer> al=new TreeSet<Integer>();
		for(int i=1;i<=n;i++)
			al.add(i);
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		
		int[] ans=new int[n];
		for(int i=0;i<n;i++){
			if(al.contains(a[i])){
				al.remove(Integer.valueOf(a[i]));
				ans[i]=a[i];
				a[i]=0;
			}
		}
		for(int i=0;i<n;i++){
			if(a[i]>0){
				ans[i]=al.first();
				al.pollFirst();
			}
		}
		for(int i=0;i<n;i++)
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
