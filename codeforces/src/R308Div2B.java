import java.util.Scanner;

public class R308Div2B {
	static final int MAXN=11;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		long[] a=new long[MAXN];
		for(int i=1;i<MAXN;i++)
			a[i]=(a[i-1]+1)*10-1;
		
		long[] b=new long[MAXN];
		for(int i=1;i<MAXN;i++)
			b[i]=(a[i]-a[i-1])*i;
		
		long[] c=new long[MAXN];
		for(int i=1;i<MAXN;i++)
			c[i]=c[i-1]+b[i];
		
		long sum=0;
		for(int i=1;i<MAXN;i++){
			if(n<=a[i]){
				sum=c[i-1];
				sum+=(n-a[i-1])*i;
				break;
			}
		}
		in.close();
		System.out.println(sum);
	}

}
