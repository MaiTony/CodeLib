import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class R312Div2C {
	static int MAXN=100000;
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int[] step=new int[MAXN+3];
		int[] cnt=new int[MAXN+3];
		int[] visited=new int[MAXN+3];
		for(int i=0;i<n;i++){
			int a=in.nextInt();
			LinkedList<int[]> list=new LinkedList<int[]>();
			list.add(new int[]{a,0});
			while(!list.isEmpty()){
				int x=list.getFirst()[0];
				int y=list.getFirst()[1];
				list.removeFirst();
				if(x>MAXN+3) continue;
				if(visited[x]==i+1) continue;
				visited[x]=i+1;
				cnt[x]++;
				step[x]+=y;
				list.add(new int[]{x/2,y+1});
				list.add(new int[]{x*2,y+1});
			}
		}
		
		int res=Integer.MAX_VALUE;
		for(int i=0;i<=MAXN;i++){
			if(cnt[i]==n){
				res=Math.min(res,step[i]);
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
