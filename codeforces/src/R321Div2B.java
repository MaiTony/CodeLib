import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class R321Div2B {
	static class Pair{
		long first,second;
		public Pair(long first,long second){
			this.first=first;
			this.second=second;
		}
	}
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int d=in.nextInt();
		TreeMap<Long,Long> map=new TreeMap<Long,Long>();
		for(int i=0;i<n;i++){
			Pair p=new Pair(in.nextLong(),in.nextLong());
			map.put(p.first,map.containsKey(p.first)?map.get(p.first)+p.second:p.second);
		}
		n=map.size();
		Pair[] arr=new Pair[n];
		int p=0;
		for(long k:map.keySet()){
			arr[p++]=new Pair(k,map.get(k));
		}
		long[] sum=new long[n];
		sum[0]=arr[0].second;
		for(int i=1;i<n;i++)
			sum[i]=sum[i-1]+arr[i].second;
		
		HashMap<Long,Integer> idx=new HashMap<Long,Integer>();
		p=0;
		for(long k:map.keySet()){
			idx.put(k,p++);
		}
		
		long ans=0;
		for(int i=0;i<n;i++){
			Long rkey=map.lowerKey(arr[i].first+d);
			int right=0;
			if(rkey==null)
				right=i;
			else
				right=idx.get(rkey);
			
			if(i==0)
				ans=Math.max(ans,sum[right]);
			else
				ans=Math.max(ans,sum[right]-sum[i-1]);
		}
		System.out.println(ans);
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
