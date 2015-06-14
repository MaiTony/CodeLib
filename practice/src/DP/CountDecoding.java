package DP;


//Count Possible Decodings of a given Digit Sequence
public class CountDecoding {
	public void solve(String digits) {
		int n = digits.length();
		
		System.out.println(countDecoding(n, digits));
		
	}
	int countDecoding(int n, String digits) {
		if (n == 0 || n == 1)
			return 1;
		
		int count = 0;
		
		if (digits.charAt(n - 1) > '0')
			count = countDecoding(n - 1, digits);
		
		if (digits.charAt(n - 2) < '2' || digits.charAt(n - 2) == '2' && digits.charAt(n - 1) < '7')
			count += countDecoding(n - 2, digits);
		
		return count;
	}
	
	public static void main(String[] args) {
		new CountDecoding().solve("121");
		new CountDecoding().solve("1234");
		
	}

}
