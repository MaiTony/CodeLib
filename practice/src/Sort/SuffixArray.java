package Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SuffixArray {
	static int MAXN=65536;
	static int MAXLG=17;
	static class entry{
		int[] nr=new int[2]; 
		int p;
	};
	static class cmp implements Comparator<entry>{
		public int compare(entry a, entry b) {
			 return a.nr[0]==b.nr[0]?(a.nr[1]<b.nr[1]?-1:1):(a.nr[0]<b.nr[0]?-1:1);
		}
	}
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int[][] P=new int[MAXLG][MAXN];
		int N,i,stp,cnt;
		char[] A=in.next().toCharArray();
		in.close();
		N=A.length;
		entry[] L=new entry[N];

		for(i=0;i<N;i++)
			P[0][i]=A[i]-'a';
		
		for(stp=1,cnt=1;(cnt>>1)<N;stp++,cnt<<=1){
			for(i=0;i<N;i++){
				L[i]=new entry();
				L[i].nr[0]=P[stp-1][i];
				L[i].nr[1]=i+cnt<N?P[stp-1][i+cnt]:-1;
				L[i].p=i;
			}
			Arrays.sort(L,new cmp());
			for(i=0;i<N;i++)
				P[stp][L[i].p]=(i>0&&L[i].nr[0]==L[i-1].nr[0]&&L[i].nr[1]==L[i-1].nr[1])?P[stp][L[i-1].p]:i;
		}
		for(i=0;i<N;i++)
			System.out.println(P[stp-1][i]);
	} 
}
