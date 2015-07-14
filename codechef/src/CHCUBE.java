import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CHCUBE {
	static final int N=6;
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int T=in.nextInt();
		while(T-->0){
			String[] color=new String[N];
			for(int i=0;i<N;i++)
				color[i]=in.nextToken();
			
			boolean same=false;
			for(int i=0;i<2&&!same;i++)
				for(int j=2;j<4&&!same;j++)
					for(int k=4;k<6&&!same;k++)
						if(color[i].equals(color[j])&&color[j].equals(color[k]))
							same=true;
			if(same)
				out.println("YES");
			else
				out.println("NO");
		}
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
