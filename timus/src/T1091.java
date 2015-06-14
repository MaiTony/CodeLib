import java.io.PrintWriter;
import java.util.Scanner;

public class T1091 {
	static int n, b, f;
	static int[][][] ways = new int[51][51][51];
	static int gcd( int a, int c){
		if ( a == 0 ) return c;
		return gcd(c%a,a);
	}
	static int getways( int d, int g, int last ){
		if ( d==n ) return 1;

		int s=0, i,j;
		for ( i=last; i<=b; i++ )
			if ( (j=gcd(i,g)) > 1 )
				s=Math.min( 10000, s+getways(d+1,j,i+1) );

		return ways[d][g][last]=s;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		n = in.nextInt();
		b = in.nextInt();

		out.println(getways(0,0,2));
		out.flush();
		in.close();
	}
	
}
