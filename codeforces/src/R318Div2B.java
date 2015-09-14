import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class R318Div2B {
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int m=in.nextInt();
		if(m==0){
			System.out.println(-1);
		}else{
			HashMap<Integer,ArrayList<Integer>> a=new HashMap<Integer,ArrayList<Integer>>();
			for(int i=0;i<=n;i++)
				a.put(i,new ArrayList<Integer>());
			for(int i=0;i<m;i++){
				int b=in.nextInt();
				int c=in.nextInt();
				a.get(b).add(c);
				a.get(c).add(b);
			}
			int min=Integer.MAX_VALUE;
			for(int i=1;i<=n;i++){
				if(a.get(i).size()==0) continue;
				for(int j=0;j<a.get(i).size();j++){
					int jj=a.get(i).get(j);
					for(int k=j+1;k<a.get(i).size();k++){
						int kk=a.get(i).get(k);
						if(a.get(jj).contains(Integer.valueOf(kk))){
							min=Math.min(min,a.get(i).size()+a.get(jj).size()+a.get(kk).size()-6);
						}
					}
				}
			}
			System.out.println(min==Integer.MAX_VALUE?-1:min);
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
