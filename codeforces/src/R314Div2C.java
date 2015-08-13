import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class R314Div2C {
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		long k=in.nextLong();
		long[] a=new long[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextLong();
		HashMap<Long,long[]> map=new HashMap<Long,long[]>();
		for(int i=0;i<n;i++){
			long[] v=new long[3];
			if(map.containsKey(a[i]))
				v=map.get(a[i]);
			if(Math.abs(a[i])%(k*k)==0){
				long b=a[i]/k;
				if(map.containsKey(b))
					v[2]+=map.get(b)[1];
			}
			if(Math.abs(a[i])%k==0){
				long b=a[i]/k;
				if(map.containsKey(b))
					v[1]+=map.get(b)[0];
			}
			v[0]++;
			map.put(a[i],v);
		}
		long ans=0;
		for(long key:map.keySet()){
			ans+=map.get(key)[2];
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
