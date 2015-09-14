import java.util.Scanner;


public class R319Div2A {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int x=in.nextInt();
		in.close();
		
		int ans=0;
		for(int i=1;i<=n;i++){
			if(x%i==0&&x/i<=n){
				ans++;
			}
		}
		System.out.println(ans);
	}

}
