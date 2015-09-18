import java.util.HashSet;
import java.util.Scanner;


public class R052Div2A {
	static String[] alcohol={"ABSINTH", "BEER", "BRANDY", "CHAMPAGNE", "GIN", "RUM", "SAKE", "TEQUILA", "VODKA", "WHISKEY", "WINE"};
	public static void main(String[] args) {
		HashSet<String> set=new HashSet<String>();
		for(int i=0;i<alcohol.length;i++)
			set.add(alcohol[i]);
		for(int i=0;i<18;i++)
			set.add(String.valueOf(i));
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int ans=0;
		for(int i=0;i<n;i++)
			if(set.contains(in.next()))
				ans++;
		System.out.println(ans);
		in.close();
	}

}
