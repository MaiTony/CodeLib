
import java.io.PrintWriter;
import java.util.Scanner;


public class T1723 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		char[] str = new char[50];
		int maxi;
		int max;
		int i=0;
		int[] ch = new int[26];

		str = in.next().toCharArray();
		int n = str.length;
		while(i < n) ch[str[i ++] - 'a'] ++;

		maxi = 0;
		max = ch[maxi];

		for(i = 1;i < 26;i ++) {
			if(ch[i] > max) {
				maxi = i;
				max = ch[maxi];
			}
		}
		out.println((char)('a' + maxi));
		out.flush();
		in.close();
	}

}
