import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class R309Div2B {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		char[][] a=new char[n][n];
		for(int i=0;i<n;i++)
			a[i]=in.nextToken().toCharArray();
		
		String cmp="";
		for(int i=0;i<n;i++)
			cmp+='1';
		
		int max=0;
		for(int r=0;r<n;r++){
			char[][] b=a.clone();
			for(int c=0;c<n;c++){
				if(a[r][c]=='0'){
					for(int r1=0;r1<n;r1++){
						b[r1][c]=b[r1][c]=='0'?'1':'0';
					}
				}
			}
			
			int cnt=0;
			for(int r1=0;r1<n;r1++)
				if(String.valueOf(b[r1]).equals(cmp))
					cnt++;
			max=Math.max(max,cnt);
		}
		System.out.println(max);
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

