import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class R054Div2C {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int[] h=new int[n];
		int[] x=new int[n];
		for(int i=0;i<n;i++) h[i]=in.nextInt();
		for(int i=0;i<(n+1)/2;i++){
			x[i]=i+1;
			x[n-i-1]=i+1;
		}
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		int minus;
		for(int i=0;i<n;i++){
			minus=h[i]-x[i];
			map.put(minus,map.containsKey(minus)?map.get(minus)+1:1);
		}
		int max=0;
		for(int y:map.keySet()){
			if(y>=0)
				max=Math.max(max,map.get(y));
		}
		
		System.out.println(n-max);
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
