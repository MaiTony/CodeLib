import java.util.Scanner;


public class R054Div2A {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s=in.next();
		in.close();
		String cmp="hello";
		boolean find=true;
		int idx=0;
		for(int i=0;i<cmp.length()&&find;i++){
			idx=s.indexOf(cmp.charAt(i),idx);
			if(idx<0)
				find=false;
			idx++;
		}
		if(find)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
