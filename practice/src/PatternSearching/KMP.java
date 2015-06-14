package PatternSearching;

public class KMP {
	
	public static void main(String[] args) {
		char[] txt = "ACACDACACBA".toCharArray();
		char[] pat = "ACACC".toCharArray();
		
		KMPSearch(pat, txt);
	}
	
	static void KMPSearch(char[] pat, char[] txt) {
		int M = pat.length;
		int N = txt.length;
		
		int[] lps = new int[M];
		
		int j = 0;
		
		computeLPSArray(pat, M, lps);
		
		int i = 0;
		while (i < N) {
			if (pat[j] == txt[i]) {
				j ++;
				i ++;
			}
			
			if (j == M) {
				System.out.println("Found pattern at index " + (i - j));
				j = lps[j - 1];
			} else if (i < N && pat[j] != txt[i]) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i ++;
				}
			}
		}
	}
	
	static void computeLPSArray(char[] pat, int M, int[] lps) {
		int len = 0;
		int i;
		
		lps[0] = 0;
		i = 1;
		
		while (i < M) {
			if (pat[i] == pat[len]) {
				len ++;
				lps[i] = len;
				i ++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i ++;
				}
			}
		}
	}
}
