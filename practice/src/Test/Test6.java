package Test;

public class Test6 {
	
	private int area(int x0, int y0, int x1, int y1, int x2, int y2) {
		return x0 * y1 + x2 * y0 + x1 * y2 - x2 * y1 - x0 * y2 - x1 * y0;
	}
	
	public int solve(int[] a, int[] b, int[] c) {
		int ans = 0;
		
		int abc = Math.abs(area(a[0], a[1], b[0], b[1], c[0], c[1]));
		
		for (int x = 1; x <= 99; x ++) {
			for (int y = 1; y <=99; y ++) {
				int oab = Math.abs(area(x * 10, y * 10, a[0], a[1], b[0], b[1])); 
				int obc = Math.abs(area(x * 10, y * 10, b[0], b[1], c[0], c[1]));
				int oca = Math.abs(area(x * 10, y * 10, c[0], c[1], a[0], a[1]));
				
				if (abc - oab - obc - oca == 0)
					ans ++;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Test6 t = new Test6();
		
		int[] a0 = {15, 15};
		int[] b0 = {15, 68};
		int[] c0 = {68, 15};
		
		int[] a1 = {107, 69};
		int[] b1 = {85, 15};
		int[] c1 = {145, 15};
		
		System.out.println(t.solve(a0, b0, c0));
		System.out.println(t.solve(a1, b1, c1));
		
	}

}
