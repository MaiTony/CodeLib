import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class R093Div1B {
	static char[] s;
	static int n;
	static int[] z;
	
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		s=in.nextToken().toCharArray();
		n=s.length;
		z=new int[n];
		Z();
		
		int maxz=0,res=0;
		for(int i=1;i<n;i++){
			if(z[i]==n-i&&maxz>=n-i){
				res=n-i;
				break;
			}
			maxz=Math.max(maxz,z[i]);
		}
		if(res==0)
			System.out.println("Just a legend");
		else
			System.out.println(String.valueOf(s).substring(0,res));
	}
	static void Z(){
		int L=0,R=0;
		for(int i=1;i<n;i++){
			if(i>R){
				L=R=i;
				while(R<n&&s[R-L]==s[R])
					R++;
				z[i]=R-L;
				R--;
			}else{
				int k=i-L;
				if(z[k]<R-i+1)
					z[i]=z[k];
				else{
					L=i;
					while(R<n&&s[R-L]==s[R])
						R++;
					z[i]=R-L;
					R--;
				}
			}
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
