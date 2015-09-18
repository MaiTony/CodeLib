import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class R320Div2B {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt()*2;
		int[][] person=new int[1000001][2];
		for(int i=1;i<=n;i++){
			for(int j=1;j<i;j++){
				int x=in.nextInt();
				person[x][0]=i;
				person[x][1]=j;
			}
		}
		int[] an=new int[1001];
		boolean[] used=new boolean[1001];
		used[0]=true;
		for(int i=1000000;i>0;i--){
			if(!used[person[i][0]]&&!used[person[i][1]]){
				used[person[i][0]]=true;
				used[person[i][1]]=true;
				an[person[i][0]]=person[i][1];
				an[person[i][1]]=person[i][0];
			}
		}
		PrintWriter out=new PrintWriter(System.out);
		for(int i=1;i<=n;i++)
			out.print(an[i]+" ");
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
