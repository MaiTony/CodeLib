import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class R311Div2A {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int min1=in.nextInt();
		int max1=in.nextInt();
		int min2=in.nextInt();
		int max2=in.nextInt();
		int min3=in.nextInt();
		int max3=in.nextInt();
		if(max1+min2+min3>=n){
			System.out.println((n-min2-min3)+" "+min2+" "+min3);
		}else if(max1+max2+min3>=n){
			System.out.println(max1+" "+(n-max1-min3)+" "+min3);
		}else{
			System.out.println(max1+" "+max2+" "+(n-max1-max2));
		}
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
