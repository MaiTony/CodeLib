package Test;

public class TestJ {
	int stack[] = new int[32768];
	
	int[][][] fa = new int[10][10][10];
	
	boolean[][][] v = new boolean[10][10][10];
	
	int A, B, C;
	
	public void solve(int a, int b, int c, int n) {
		int front = 0, rear = 0, u;
		u = a * 1000000 + b * 1000 + c;
		stack[rear ++] = u;
		v[a][b][c] = true;
		fa[a][b][c] = u;
		
		while (front < rear) {
			u = stack[front ++];
			a = u / 1000000;
			b = (u % 1000000) / 1000;
			c = (u % 1000000) % 1000;

			//System.out.println(a + " " + b + " " + c);

			if (a == n || b == n || c == n) {
				int a2 = 0, b2 = 0, c2 = 0;
				String[] ans = new String[1000];
				int p = 0;
				while (true) {
					ans[p ++] = a + " " + b + " " + c;

					a2 = fa[a][b][c] / 1000000;
					b2 = (fa[a][b][c] % 1000000) / 1000;
					c2 = (fa[a][b][c] % 1000000) % 1000;
					
					if (a2 == a && b2 == b && c2 == c) break;
					
					a = a2;
					b = b2;
					c = c2;
				}
				
				while (p > 0) {
					System.out.println(ans[--p]);
				}
				
				return;
			}
			
			int a1, b1, c1, u1;
			
			if (a > 0 && b < B) {
				a1 = a + b - B > 0 ? a + b - B : 0;
				b1 = a + b - B > 0 ? B : a + b;
				c1 = c;
				u1 = a1 * 1000000 + b1 * 1000 + c1;
				if (!v[a1][b1][c1]) {
					v[a1][b1][c1] = true;
					fa[a1][b1][c1] = u;
					stack[rear ++] = u1;
				}
			}
			if (a > 0 && c < C) {
				a1 = a + c - C > 0 ? a + c - C : 0;
				b1 = b;
				c1 = a + c - C > 0 ? C : a + c;
				u1 = a1 * 1000000 + b1 * 1000 + c1;
				if (!v[a1][b1][c1]) {
					v[a1][b1][c1] = true;
					fa[a1][b1][c1] = u;
					stack[rear ++] = u1;
				}
			}
			if (b > 0 && a < A) {
				a1 = b + a - A > 0 ? A : b + a;
				b1 = b + a - A > 0 ? b + a - A : 0;
				c1 = c;
				u1 = a1 * 1000000 + b1 * 1000 + c1;
				if (!v[a1][b1][c1]) {
					v[a1][b1][c1] = true;
					fa[a1][b1][c1] = u;
					stack[rear ++] = u1;
				}
			}
			if (b > 0 && c < C) {
				a1 = a;
				b1 = b + c - C > 0 ? b + c - C : 0;
				c1 = b + c - C > 0 ? C : b + c;
				u1 = a1 * 1000000 + b1 * 1000 + c1;
				if (!v[a1][b1][c1]) {
					v[a1][b1][c1] = true;
					fa[a1][b1][c1] = u;
					stack[rear ++] = u1;
				}
			}
			if (c > 0 && a < A) {
				a1 = c + a - A > 0 ? A : c + a;
				b1 = b;
				c1 = c + a - A > 0 ? c + a - A : 0;
				u1 = a1 * 1000000 + b1 * 1000 + c1;
				if (!v[a1][b1][c1]) {
					v[a1][b1][c1] = true;
					fa[a1][b1][c1] = u;
					stack[rear ++] = u1;
				}
			}
			if (c > 0 && b < B) {
				a1 = a;
				b1 = c + b - B > 0 ? B : c + b;
				c1 = c + b - B > 0 ? c + b - B : 0;
				u1 = a1 * 1000000 + b1 * 1000 + c1;
				if (!v[a1][b1][c1]) {
					v[a1][b1][c1] = true;
					fa[a1][b1][c1] = u;
					stack[rear ++] = u1;
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		TestJ t = new TestJ();
		t.A = 6;
		t.B = 3;
		t.C = 1;
		t.solve(6, 0, 0, 4);
	}

}
