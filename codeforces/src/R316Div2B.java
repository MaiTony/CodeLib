import java.util.Scanner;

public class R316Div2B {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		if(n==1)
			System.out.println(1);
		else{
			if(n%2==0){
				if(m<=n/2){
					System.out.println(m+1);
				}else if(m>=n/2+1){
					System.out.println(m-1);
				}
			}else{
				if(m>=n/2+1){
					System.out.println(m-1);
				}else if(m<n/2+1){
					System.out.println(m+1);
				}
			}
		}
		in.close();
	}

}
