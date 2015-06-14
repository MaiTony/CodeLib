package Round1A_2010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MakeItSmooth {
	
	private int D, I, M, N;
	//private int[] S = null;
	private int[][] dp = null;
	
	public void run() throws Exception {
		String in = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/Round1A_2010/A-large-practice.in";
		String out = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/Round1A_2010/A-large-practice.out";
		
		int i, j, k, p, K;
		String[] T = null;
		int[] S = null;
		
		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		String L = null;
		
		L = reader.readLine();
		K = Integer.parseInt(L);
		
		
		for (i = 0; i < K; i ++) {
			L = reader.readLine();
			T = L.split(" ");
			D = Integer.parseInt(T[0]);
			I = Integer.parseInt(T[1]);
			M = Integer.parseInt(T[2]);
			N = Integer.parseInt(T[3]);
			
			S = new int[N];
			L = reader.readLine();
			T = L.split(" ");
			if (T.length == 0 || T.length > N) {
				System.out.print("Case #" + (i + 1) + ": 0\n");
				writer.append("Case #" + (i + 1) + ": 0\n");
				continue;
			}
			for (j = 0; j < T.length; j ++) {
				S[j] = Integer.parseInt(T[j]);
			}
			
			dp = new int[N][256];
			
			for (p = 0; p < N; p ++) {
				for (j = 0; j < 256; j ++) {
					if (p > 0) {
						dp[p][j] = dp[p - 1][j] + D;
					}
					for (k = 0; k < 256; k ++) {
						if (Math.abs(j - k) <= M) {
							dp[p][j] = Math.min(dp[p][j], dp[p - 1][k] + Math.abs(S[p] - j));
						}
					}
				}
				
				for (j = 0; j < 256; j ++) {
					for (k = 0; k < 256; k ++) {
						if (Math.abs(j - k) <= M) {
							dp[p][j] = Math.min(dp[p][j], dp[p][k] + I);
						}
					}
				}
				
				
			}
			
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		new MakeItSmooth().run();
	}

}
