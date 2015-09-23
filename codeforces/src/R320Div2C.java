import java.util.Scanner;


public class R320Div2C {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		int b=in.nextInt();
		in.close();
		if(a==b){
			System.out.println(a);
			return;
		}
		
		int lo=1;
		int hi=1000000000;
		while(lo<hi){
			int mid=(lo+hi)/2+1;
			double c=(a-b)*0.5/mid;
			if(c>=b){
				lo=mid;
			}else{
				hi=mid-1;
			}
		}
		double min=Double.MAX_VALUE;
		if((a-b)*0.5/lo>=b){
			min=(a-b)*0.5/lo;
		}
		
		
		lo=1;
		hi=1000000000;
		while(lo<hi){
			int mid=(lo+hi)/2+1;
			double c=(a+b)*0.5/mid;
			if(c>=b){
				lo=mid;
			}else{
				hi=mid-1;
			}
		}
		if((a+b)*0.5/lo>=b){
			min=Math.min(min,(a+b)*0.5/lo);
		}
		if(min==Double.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

}
