import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class R307Div2C {
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int m=in.nextInt();
		long[] a=new long[n];
		long sum=0;
		int maxi=0;
		for(int i=0;i<n;i++){
			a[i]=in.nextLong();
			sum+=a[i];
			if(a[i]>0)
				maxi=i;
		}
		
		
		long lo=0;
		long hi=sum+n;
		
		while(lo<hi){
			long mid=lo+(hi-lo)/2;
			int i=0;
			int j=0;
			long[] b=a.clone();
			while(j<m&&i<=maxi){
				j++;
				long time=mid-i-1;
				while(i<=maxi){
					if(time==0||b[maxi]==0) break;
					if(b[i]==0){
						i++;
						time--;
					}else if(time>=b[i]){
						time-=b[i];
						b[i]=0;
					}else{
						b[i]-=time;
						time=0;
					}
				}
			}
			if(b[maxi]==0)
				hi=mid;
			else
				lo=mid+1;
		}
		System.out.println(hi);
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
