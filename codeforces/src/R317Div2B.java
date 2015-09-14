import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class R317Div2B {
	static class Pair implements Comparable<Pair>{
		int first,second;
		char third;
		public Pair(int first,int second,char third){
			this.first=first;
			this.second=second;
			this.third=third;
		}
		@Override
		public int compareTo(Pair o){
			if(this.first>o.first)
				return -1;
			if(this.first<o.first)
				return 1;
			if(this.second>o.second)
				return -1;
			if(this.second<o.second)
				return 1;
			return 0;
		}
	}
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int s=in.nextInt();
		TreeMap<Character,TreeMap<Integer,Integer>> map=new TreeMap<Character,TreeMap<Integer,Integer>>();
		for(int i=0;i<n;i++){
			char d=in.nextToken().toCharArray()[0];
			int p=in.nextInt();
			int q=in.nextInt();
			if(!map.containsKey(d))
				map.put(d,new TreeMap<Integer,Integer>());
			TreeMap<Integer,Integer> t=map.get(d);
			t.put(p,t.containsKey(p)?t.get(p)+q:q);
		}
		ArrayList<Pair> ans1=new ArrayList<Pair>();
		if(map.containsKey('S')){
			for(Integer x:map.get('S').keySet()){
				ans1.add(new Pair(x,map.get('S').get(x),'S'));
			}
			Collections.sort(ans1);
		}

		ArrayList<Pair> ans2=new ArrayList<Pair>();
		if(map.containsKey('B')){
			for(Integer x:map.get('B').keySet()){
				ans2.add(new Pair(x,map.get('B').get(x),'B'));
			}
			Collections.sort(ans2);
		}
		
		PrintWriter out=new PrintWriter(System.out);
		int j=0;
		if(ans1.size()>s)
			j=ans1.size()-s;
		for(int i=j;i<ans1.size();i++)
			out.println(ans1.get(i).third+" "+ans1.get(i).first+" "+ans1.get(i).second);
		
		for(int i=0;i<s&&i<ans2.size();i++)
			out.println(ans2.get(i).third+" "+ans2.get(i).first+" "+ans2.get(i).second);
		
		out.flush();
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
