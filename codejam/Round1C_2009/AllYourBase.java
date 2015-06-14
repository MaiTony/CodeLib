package Round1C_2009;

public class AllYourBase {

	public void run() throws Exception {
		
		String input = "cats";
		char[] in = input.toCharArray();
		int [] out = new int[in.length];
		
		int n = 0;
		for (int i = 0; i < in.length; i ++) {
			if (in[i] >= '0' && in[i] <= '9') {
				if (n < (int)in[i]) {
					n = (int)in[i] -48 + 1;
				}
				out[i] = (int)in[i] -48;
			} else if (in[i] >= 'a' && in[i] <= 'z') {
				if (n < (int)in[i]) {
					n = (int)in[i] - 97 + 11;
				}
				out[i] = (int)in[i] - 97 + 10;
			}
		}
		
		int p = 0;
		for (int i = 0; i < in.length; i ++) {
			for (int j = 0; j < in.length - i - 1; j ++) {
				out[i] = out[i] * n;
			}
			p += out[i];
		}
		
		System.out.println(p);
	
	}
	public static void main(String[] args) throws Exception {
		new AllYourBase().run();
	}

}
