import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MCHEF_STL {
	static class Oper{
		int l,r,k;
	}
	static class Pair implements Comparable<Pair>{
		int first,second;
		public Pair(int first,int second){
			this.first=first;
			this.second=second;
		}
		public int compareTo(Pair o) {
			if(this.first<o.first)
				return -1;
			if(this.first>o.first)
				return 1;
			if(this.second<o.second)
				return -1;
			if(this.second>o.second)
				return 1;
			return 0;
		}
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Pair)) return false;
			Pair pairo=(Pair)o;
			return this.first==pairo.first&&this.second==pairo.second;
		}
	}
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int T=in.nextInt();
		while(T-->0){
			int N=in.nextInt();
			int K=in.nextInt();
			int M=in.nextInt();
			int[] A=new int[N+1];
			for(int i=1;i<=N;i++)
				A[i]=in.nextInt();

			Oper[] operarray=new Oper[M];
			for(int i=0;i<M;i++){
				operarray[i]=new Oper();
				operarray[i].l=in.nextInt()-1;
				operarray[i].r=in.nextInt()-1;
				operarray[i].k=in.nextInt();
			}
			ArrayList<ArrayList<Integer>> L=new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> R=new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<N;i++){
				L.add(new ArrayList<Integer>());
				R.add(new ArrayList<Integer>());
			}
			for(int i=0;i<M;i++){
				L.get(operarray[i].l).add(i);
				R.get(operarray[i].r).add(i);
			}
			TreeSet<Pair> iset=new TreeSet<Pair>();
			int[] min=new int[N+1];
			Arrays.fill(min,Integer.MAX_VALUE);
			for(int i=0;i<N;i++){
				for(int j=0;j<L.get(i).size();j++){
					int operindex=L.get(i).get(j);
					int cost=operarray[operindex].k;
					iset.add(new Pair(cost,operindex));
				}
				if(iset.size()>0)
					min[i+1]=iset.first().first;
				
				for(int j=0;j<R.get(i).size();j++){
					int operindex=R.get(i).get(j);
					int cost=operarray[operindex].k;
					iset.remove(new Pair(cost,operindex));
				}
			}
			
			long[] dp=new long[K+1];
			long sum=0;
			for(int i=1;i<=N;i++){
				sum+=A[i];
				if(A[i]<0){
					for(int j=K;j>=min[i];j--){
						dp[j]=Math.max(dp[j], dp[j-min[i]]-A[i]);
					}
				}
			}
			out.println(sum+dp[K]);
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
