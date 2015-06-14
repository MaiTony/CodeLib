package Test;

public class TestI {
	
	int n, total = 0;
	int[] C;
	
	public void search(int cur) {
		int i, j;
		
		if (cur == n) total ++;
		else
			for (i = 0; i < n; i ++) {
				boolean f = false;
				C[cur] = i;
				for (j = 0; j < cur && !f; j ++)
					if (C[j] == C[cur] || cur - C[cur] == j - C[j] || cur + C[cur] == j + C[j])
						f = true;
				
				if (!f)
					search(cur + 1);
			}
	}
	
	public static void main(String[] args) {
		TestI t = new TestI();
		
		t.n = 8;
		t.C = new int[t.n];
		t.search(0);
		System.out.println(t.total);
		
	}

}
