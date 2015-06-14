package QR2015;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B {
	static String path="D:/Algorithm/codejam/QR2015/B-large-practice.";
	public static void main(String[] args) throws Exception {
		FastScanner in=new FastScanner(path+"in");
		File file=new File(path+"out");
		if(file.exists())
			file.delete();
		BufferedWriter out=new BufferedWriter(new FileWriter(path+"out"));
		
		int t,T=in.nextInt();
		for(t=0;t<T;t++){
			int i,k,n=in.nextInt();
			TreeMap<Integer,Integer> d=new TreeMap<Integer,Integer>();
			for(i=0;i<n;i++){
				k=in.nextInt();
				System.out.print(k+" ");
				if(!d.containsKey(k))
					d.put(k,1);
				else
					d.put(k,d.get(k)+1);
			}
			System.out.println();
			int ans=d.lastKey();
			i=0;
			while(d.lastKey()!=1){
				i++;
				k=d.lastKey();
				
				int k1,k2,k3;
				if(d.get(k)==1){
					if(d.lowerKey(k)!=null)
						k3=gcd(k,d.lowerKey(k));
					else
						k3=(int)Math.sqrt(k);
					if(k3>1&&k%k3==0){
						k1=k-k3;
						k2=k-k1;
					}else{
						k1=k/2;
						k2=k-k1;
					}
				}else{
					k1=k/2;
					k2=k-k1;
				}
				if(!d.containsKey(k1))
					d.put(k1,1);
				else
					d.put(k1,d.get(k1)+1);
				
				if(!d.containsKey(k2))
					d.put(k2,1);
				else
					d.put(k2,d.get(k2)+1);

				if(d.get(k)==1)
					d.remove(k);
				else
					d.put(k,d.get(k)-1);
				
				ans=Math.min(ans,d.lastKey()+i);
			}
			System.out.println("Case #"+(t+1)+": "+ans);
			out.append("Case #"+(t+1)+": "+ans+"\n");
		}
		
		out.flush();
		out.close();
	}
	static int gcd(int a,int b){
		if(b==0)
			return a;
		return gcd(b,a%b);
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

