package QR2015;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class A {
	static String path="D:/Algorithm/codejam/QR2015/A-large.";
	public static void main(String[] args) throws Exception {
		FastScanner in=new FastScanner(path+"in");
		File file=new File(path+"out");
		if(file.exists())
			file.delete();
		BufferedWriter out=new BufferedWriter(new FileWriter(path+"out"));
		
		int t,T=in.nextInt();
		for(t=0;t<T;t++){
			int i,n=in.nextInt();
			char[] s=in.nextToken().toCharArray();
			int up=0,ans=0;
			for(i=0;i<=n;i++){
				if(up<i&&s[i]!='0'){
					ans+=i-up;
					up=i;
				}
				up+=s[i]-'0';
			}
			out.append("Case #"+(t+1)+": "+ans+"\n");
		}
		
		out.flush();
		out.close();
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

