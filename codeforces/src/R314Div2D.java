import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class R314Div2D {
	static int n,k,a,m;
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		n=in.nextInt();
		k=in.nextInt();
		a=in.nextInt();
		
		int m=in.nextInt();
		int ans=0;
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		map.put(1,n);
		int ships=calc(1,n);
		for(int i=0;i<m;i++){
			int x=in.nextInt();
			int newk1=0,newk2=0;
			int L=map.floorKey(x);
			int R=map.get(L);
			if(x-1>=L)
				newk1=calc(L,x-1);
			if(x+1<=R)
				newk2=calc(x+1,R);
			ships-=calc(L,R);
			ships+=newk1+newk2;
			if(ships<k){
				System.out.println(i+1);
				return;
			}
			map.remove(x);
			if(x-1>=L)
				map.put(L,x-1);
			if(x+1<=R)
				map.put(x+1,R);
		}
		if(ans==0)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
	static int calc(int l,int r){
		return (r-l+2)/(a+1);
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
