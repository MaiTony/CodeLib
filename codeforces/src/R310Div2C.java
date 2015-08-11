import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class R310Div2C {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int k=in.nextInt();
		ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>();
		int[] m=new int[k];
		int one=0;
		for(int i=0;i<k;i++){
			a.add(new ArrayList<Integer>());
			m[i]=in.nextInt();
			for(int j=0;j<m[i];j++){
				int b=in.nextInt();
				a.get(i).add(b);
				if(b==1)
					one=i;
			}
		}
		int l=0;
		for(l=0;l<m[one];l++)
			if(a.get(one).get(l)-a.get(one).get(0)>l)
				break;
		System.out.println(2*n-k-2*l+1);
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
