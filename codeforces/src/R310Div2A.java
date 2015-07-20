import java.util.Scanner;
import java.util.Stack;


public class R310Div2A {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		char[] a=in.next().toCharArray();
		Stack<Character> s=new Stack<Character>();
		for(int i=0;i<n;i++){
			if(s.size()>0&&s.peek()!=a[i])
				s.pop();
			else
				s.push(a[i]);
		}
		System.out.println(s.size());
		in.close();
	}

}
