import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class R316Div2C {
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int n=in.nextInt();
		int m=in.nextInt();
		char[] s=in.nextToken().toCharArray();
		
		boolean[] ok=new boolean[n+2];
		int cnt=0,group=0;
		for(int i=0;i<n;i++){
			if(s[i]=='.'){
				cnt++;
				if(i==0||s[i-1]!='.')
					group++;
				ok[i+1]=true;
			}
		}

		for(int i=0;i<m;i++){
			int pos=in.nextInt();
			char c=in.nextToken().toCharArray()[0];
			boolean a=ok[pos];
			boolean b=c=='.'?true:false;
			if(a!=b){
				if(a){
					cnt--;
				}else{
					cnt++;
				}
				if(ok[pos-1]&&ok[pos+1]&&!b){
					group++;
				}
				if(ok[pos-1]&&ok[pos+1]&&b){
					group--;
				}
				if(!ok[pos-1]&&!ok[pos+1]&&!b){
					group--;
				}
				if(!ok[pos-1]&&!ok[pos+1]&&b){
					group++;
				}
			}
			out.println(cnt-group);
			ok[pos]=b;
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
