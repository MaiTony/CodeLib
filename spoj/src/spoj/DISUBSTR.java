package spoj;
/**
 * Suffix Array
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
	
	public class DISUBSTR {
		static int MAXN=500;
		static int MAXLG=500;

		public static void main(String[] args) {
			FastScanner in=new FastScanner();
			PrintWriter out=new PrintWriter(System.out);
			String s;
			char[] txt;
			int i,j,n,t=in.nextInt();
			long ans=0;
			for(i=0;i<t;i++){
				s=in.nextToken();
				txt=s.toCharArray();
				int[][] suffixes=buildSuffixArray(txt,txt.length);
				n=suffixes.length;
				String cur,pre;
				ans=s.substring(suffixes[0][2]).length();
				for(j=1;j<n;j++){
					pre=s.substring(suffixes[j-1][2]);
					cur=s.substring(suffixes[j][2]);
					ans+=lcp(pre,cur);
				}
				out.println(ans);
			}
			out.flush();
		}
		public static int lcp(String s1,String s2){
			int i=0;
			while(i<s1.length()&&i<s2.length()&&s1.charAt(i)==s2.charAt(i)) i++;
			return s2.length()-i;
		}
		static class cmp implements Comparator<int[]>{
			public int compare(int[] a, int[] b) {
				if (a[0]==b[0]){
					if(a[1]<b[1])
						return -1;
					else if(a[1]==b[1])
						return 0;
					else
						return 1;
				}else if(a[0]<b[0]){
					return -1;
				}else{
					return 1;
				}
			}
		}
		static int[][] buildSuffixArray(char[] txt,int N) {
			int[][] P=new int[MAXLG][MAXN];
			int i,stp,cnt;
			int[][] L=new int[N][3];

			for(i=0;i<N;i++)
				P[0][i]=txt[i]-'A';
			
			for(stp=1,cnt=1;(cnt>>1)<N;stp++,cnt<<=1){
				for(i=0;i<N;i++){
					L[i][0]=P[stp-1][i];
					L[i][1]=(i+cnt<N)?P[stp-1][i+cnt]:-1;
					L[i][2]=i;
				}
				Arrays.sort(L,new cmp());
				for(i=0;i<N;i++)
					P[stp][L[i][2]]=(i>0&&L[i][0]==L[i-1][0]&&L[i][1]==L[i-1][1])?P[stp][L[i-1][2]]:i;
			}
			return L;
		}
		static class FastScanner{
			BufferedReader br;
			StringTokenizer st;
			public FastScanner(){br = new BufferedReader(new InputStreamReader(System.in));}
			String nextToken(){
				while(st == null||!st.hasMoreElements()){
					try{st = new StringTokenizer(br.readLine());}catch(Exception e){}
				}
				return st.nextToken();
			}
			int nextInt(){return Integer.parseInt(nextToken());}
			long nextLong(){return Long.parseLong(nextToken());}
			double nextDouble(){return Double.parseDouble(nextToken());}
		}
	}
