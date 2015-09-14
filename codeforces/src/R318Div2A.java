import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class R318Div2A {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int first=0;
		TreeMap<Integer,Integer> a=new TreeMap<Integer,Integer>();
		for(int i=0;i<n;i++){
			int k=in.nextInt();
			if(i==0){
				first=k;
			}else{
				a.put(k,a.containsKey(k)?a.get(k)+1:1);
			}
		}
		int ans=0;
		int k=a.lastKey();
		while(first<=k){
			if(first+a.get(k)<=k){
				first+=a.get(k);
				ans+=a.get(k);
				a.put(k-1,a.containsKey(k-1)?a.get(k-1)+a.get(k):a.get(k));
				a.remove(k);
			}else{
				ans+=k-first+1;
				break;
			}
			k=a.lastKey();
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
