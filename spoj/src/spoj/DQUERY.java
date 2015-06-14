package spoj;
/**
 * MO's algorithm
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class DQUERY {
	static int BLOCK=555;
	static int[] a=new int[30_000],ans=new int[200_000],cnt=new int[1_000_001];
	static int answer=0;
	
	static class Node{
		int L,R,i;
	}
	static class Cmp implements Comparator<Node>{
		public int compare(Node a, Node b) {
			if(a.L/BLOCK<b.L/BLOCK)
				return -1;
			else if(a.L/BLOCK>b.L/BLOCK)
				return 1;
			else{
				if(a.R<b.R)
					return -1;
				else if(a.R>b.R)
					return 1;
				else
					return 0;
			}
		}
	}
	static void add(int pos){
		cnt[a[pos]]++;
		if(cnt[a[pos]]==1){
			answer++;
		}
	}
	static void remove(int pos){
		cnt[a[pos]]--;
		if(cnt[a[pos]]==0){
			answer--;
		}
	}
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int i,m,n=in.nextInt();
		for(i=0;i<n;i++)
			a[i]=in.nextInt();
		m=in.nextInt();
		Node[] q=new Node[m];
		for(i=0;i<m;i++){
			q[i]=new Node();
			q[i].L=in.nextInt()-1;
			q[i].R=in.nextInt()-1;
			q[i].i=i;
		}
		Arrays.sort(q,new Cmp());
		
		int curL=0,curR=0;
		for(i=0;i<m;i++){
			int L=q[i].L,R=q[i].R;
			while(curL<L){
				remove(curL);
				curL++;
			}
			while(curL>L){
				add(curL-1);
				curL--;
			}
			while(curR<=R){
				add(curR);
				curR++;
			}
			while(curR>R+1){
				remove(curR-1);
				curR--;
			}
			ans[q[i].i]=answer;
		}
		for(i=0;i<m;i++)
			out.println(ans[i]);
		out.flush();
	}
	
	static class FastScanner{
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(){br = new BufferedReader(new InputStreamReader(System.in));}
		String nextToken(){
			while(st == null||!st.hasMoreElements()){
				try{st = new StringTokenizer(br.readLine());}catch(Exception e){}
			}
			return st.nextToken();
		}
		int nextInt(){return Integer.parseInt(nextToken());}
		long nextLong(){return Long.parseLong(nextToken());}
		double nextDouble(){return Double.parseDouble(nextToken());}
	}
}
