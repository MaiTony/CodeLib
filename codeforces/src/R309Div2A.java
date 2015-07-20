import java.util.HashSet;
import java.util.Scanner;


public class R309Div2A {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String a=in.next();
		HashSet<String> b=new HashSet<String>();
		for(char j='a';j<='z';j++)
			b.add(j+a);
		int n=a.length();
		for(int i=0;i<n;i++)
			for(char j='a';j<='z';j++)
				b.add(a.substring(0,i+1)+j+a.substring(i+1));
		
		System.out.println(b.size());
		in.close();
	}

}
