import java.util.Scanner;


public class R306Div2C {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String digit=in.next();
		in.close();
		int n=digit.length();
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				for(int k=j+1;k<n;k++){
					int div=(digit.charAt(i)-'0')*100+(digit.charAt(j)-'0')*10+(digit.charAt(k)-'0');
					if(div%8==0){
						System.out.println("YES");
						System.out.println(div);
						return;
					}
				}
				int div=(digit.charAt(i)-'0')*10+(digit.charAt(j)-'0');
				if(div%8==0){
					System.out.println("YES");
					System.out.println(div);
					return;
				}
			}
			int div=(digit.charAt(i)-'0');
			if(div%8==0){
				System.out.println("YES");
				System.out.println(div);
				return;
			}
		}
		System.out.println("NO");
	}

}
