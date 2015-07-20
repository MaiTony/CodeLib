import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class R312Div2A {
	static class Node implements Comparable<Node> {
		int x;
		int a;
		
		@Override
		public int compareTo(Node a) {
			return this.x<a.x?-1:1;
		}
	}
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		Node[] l=new Node[n];
		for(int i=0;i<n;i++){
			l[i]=new Node();
			l[i].x=in.nextInt();
			l[i].a=in.nextInt();
		}
		Arrays.sort(l);
		int minus=0,plus=0,zero=0,mi=-1,pi=-1,zi=-1;
		for(int i=0;i<n;i++){
			if(l[i].x<0){
				minus++;
				mi=i;
			}else if(l[i].x>0){
				plus++;
				if(pi==-1)
					pi=i;
			}else if(l[i].x==0){
				zero++;
				zi=i;
			}
		}

		int sum=0;
		if(zi!=-1){
			sum+=l[zi].a;
		}
		if(mi==-1){
			sum+=l[pi].a;
		}else if(pi==-1){
			sum+=l[mi].a;
		}else{
			if(minus<plus){
				for(int i=mi;i>=0;i--){
					sum+=l[i].a;
				}
				for(int i=pi;i<=pi+minus;i++){
					sum+=l[i].a;
				}
			}else if(minus>plus){
				for(int i=mi;i>=mi-plus;i--){
					sum+=l[i].a;
				}
				for(int i=pi;i<n;i++){
					sum+=l[i].a;
				}
			}else{
				for(int i=mi;i>=0;i--){
					sum+=l[i].a;
				}
				for(int i=pi;i<n;i++){
					sum+=l[i].a;
				}
			}
		}
		System.out.println(sum);
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
