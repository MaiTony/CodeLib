import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;


public class R323Div2A {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		HashSet<Integer> horizonal=new HashSet<Integer>();
		HashSet<Integer> vertical=new HashSet<Integer>();
		ArrayList<Integer> ans=new ArrayList<Integer>();
		for(int i=0;i<n*n;i++){
			int h=in.nextInt();
			int v=in.nextInt();
			if(!horizonal.contains(h)&&!vertical.contains(v)){
				ans.add(i+1);
				horizonal.add(h);
				vertical.add(v);
			}
		}
		PrintWriter out=new PrintWriter(System.out);
		for(int i=0;i<ans.size();i++)
			out.print(ans.get(i)+" ");
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
