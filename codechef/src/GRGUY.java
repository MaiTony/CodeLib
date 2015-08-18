import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class GRGUY {
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int T=in.nextInt();
		while(T-->0){
			String[] lane=new String[2];
			lane[0]=in.nextToken();
			lane[1]=in.nextToken();
			int n=lane[0].length();
			if(lane[0].charAt(0)=='#'&&lane[1].charAt(0)=='#'||
				lane[0].charAt(n-1)=='#'&&lane[1].charAt(n-1)=='#'){
				out.println("No");
				continue;
			}
			LinkedList<int[]> queue=new LinkedList<int[]>();
			HashMap<Integer,Integer> visited=new HashMap<Integer,Integer>();
			if(lane[0].charAt(0)=='.'){
				queue.add(new int[]{0,0,0});
			}
			if(lane[1].charAt(0)=='.'){
				queue.add(new int[]{1,0,0});
			}
			int min=2*n;
			while(!queue.isEmpty()){
				int[] p=queue.removeFirst();
				if(p[1]==n-1){
					if(lane[p[0]].charAt(n-1)=='.'){
						min=Math.min(min,p[2]);
					}
					continue;
				}
				if(!visited.containsKey(p[0]*n+p[1])||visited.containsKey(p[0]*n+p[1])&&visited.get(p[0]*n+p[1])>p[2]){
					visited.put(p[0]*n+p[1],p[2]);
					queue.add(p);
					if(lane[p[0]].charAt(p[1]+1)=='.'){
						queue.add(new int[]{p[0],p[1]+1,p[2]});
					}
					if(lane[(p[0]+1)%2].charAt(p[1])=='.'){
						queue.add(new int[]{(p[0]+1)%2,p[1],p[2]+1});
					}
					if(lane[(p[0]+1)%2].charAt(p[1]+1)=='.'){
						queue.add(new int[]{(p[0]+1)%2,p[1]+1,p[2]+1});
					}
				}
			}
			if(min==2*n)
				out.println("No");
			else{
				out.println("Yes");
				out.println(min);
			}
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
