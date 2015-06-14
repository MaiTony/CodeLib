package Round1A_2015;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class B {
	static String path="D:/Algorithm/codejam/Round1A_2015/B-small-attempt1.";
	public static void main(String[] args) throws Exception {
		FastScanner in=new FastScanner(path+"in");
		File file=new File(path+"out");
		if(file.exists())
			file.delete();
		BufferedWriter out=new BufferedWriter(new FileWriter(path+"out"));
		
		int t,T=in.nextInt();
		for(t=0;t<T;t++){
			int b=in.nextInt();
			long n=in.nextLong();
			int i,j=0;
			long[] m=new long[b];
			for(i=0;i<b;i++)
				m[i]=in.nextLong();
			long d=1; 
			for(i=0;i<b;i++){
				d=lcm(m[i],d);
			}
			long cnt=0;
			for(i=0;i<b;i++){
				cnt+=d/m[i];
			}
			
			n=n%cnt;
			if(n==0){
				n=b;
			}else{
				int x=0;
				for(i=0;i<d;i++){
					for(j=0;j<b;j++){
						if(i%m[j]==0){
							x++;
							if(x==n)
								break;
						}
					}
					if(x==n)
						break;
				}
				n=j+1;
			}
			out.append("Case #"+(t+1)+": "+n+"\n");
		}
		
		out.flush();
		out.close();
	}
	static long lcm(long a,long b){
		return a*b/gcd(a,b);
	}
	static long gcd(long a,long b){
		return b==0?a:gcd(b,a%b);
	}
	static class FastScanner{
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(String file) throws Exception {br=new BufferedReader(new FileReader(file));}
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

