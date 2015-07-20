import java.util.Scanner;

public class R306Div2A {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s=in.next();
		in.close();
		int i=s.indexOf("AB");
		if(i>-1){
			i=s.indexOf("BA",i+2);
			if(i>-1){
				System.out.println("YES");
				return;
			}
		}
		
		i=s.indexOf("BA");
		if(i>-1){
			i=s.indexOf("AB",i+2);
			if(i>-1){
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

}
