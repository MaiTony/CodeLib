import java.util.Scanner;


public class R320Div2A {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		in.close();
		int ans=0;
		int high=30;
		while(n>0){
			for(int i=high;i>=0;i--)
				if(n>=(1<<i)){
					n-=(1<<i);
					high=i;
					ans++;
					break;
				}
		}
		System.out.println(ans);
	}

}
