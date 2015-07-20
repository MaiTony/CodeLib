import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class R310Div2B {
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		int[] b=a.clone();
		while(b[0]!=0){
			for(int i=0;i<n;i++){
				if(i%2==0)
					b[i]=(b[i]+1)%n;
				else
					b[i]=(b[i]-1+n)%n;
			}
		}
		
		boolean f=true;
		for(int i=0;i<n&&f;i++)
			if(b[i]!=i)
				f=false;
		if(f){
			System.out.println("Yes");
			return;
		}
		
		b=a.clone();
		while(b[0]!=0){
			for(int i=0;i<n;i++){
				if(i%2!=0)
					b[i]=(b[i]+1)%n;
				else
					b[i]=(b[i]-1+n)%n;
			}
		}
		
		f=true;
		for(int i=0;i<n&&f;i++)
			if(b[i]!=i)
				f=false;
		if(f){
			System.out.println("Yes");
			return;
		}
		
		System.out.println("No");
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
