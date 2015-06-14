package Mathematical;

public class Base14NumberAdd {
	
	static void sumBase14(char[] num1, char[] num2) {
		int m = num1.length;
		int n = num2.length;
		
		int x = Math.max(n, m) + 1;
		
		int[] n1 = new int[x];
		int[] n2 = new int[x];
		
		int p = x;
		for (int i = m - 1; i >= 0; i --)
			if (num1[i] == 'A' || num1[i] == 'B' || num1[i] == 'C' || num1[i] == 'D')
				n1[-- p] = num1[i] - 'A' + 10;
			else
				n1[-- p] = num1[i] - '0';
		
		p = x;
		for (int i = n - 1; i >= 0; i --)
			if (num2[i] == 'A' || num2[i] == 'B' || num2[i] == 'C' || num2[i] == 'D')
				n2[-- p] = num2[i] - 'A' + 10;
			else
				n2[-- p] = num2[i] - '0';
		
		int[] sum = new int[x];
		for (int i = x - 1; i >= 0; i --) {
			sum[i] += n1[i] + n2[i];
			if (sum[i] >= 14) {
				sum[i] -= 14;
				sum[i - 1] ++;
			}
		}
		
		boolean f = false;
		StringBuffer ans = new StringBuffer("");
		for (int i = 0; i < x; i ++) {
			if (sum[i] != 0) {
				f = true;
			}
			if (f) {
				if (sum[i] == 10)
					ans.append('A');
				else if (sum[i] == 11)
					ans.append('B');
				else if (sum[i] == 12)
					ans.append('C');
				else if (sum[i] == 13)
					ans.append('D');
				else
					ans.append(sum[i]);
			}
		}
		
		System.out.println(ans);
	}
	public static void main(String[] args) {
		char[] num1 = "DC2".toCharArray();
		char[] num2 = "DD0A3".toCharArray();
		sumBase14(num1, num2);
	}

}
