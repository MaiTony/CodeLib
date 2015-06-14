
public class DP {

	public static void main(String[] args) {
		int S = 11;
		int[] N = new int[] {1 ,3 ,5};
		int[] Min = new int[12];
		
		for (int i = 0; i < Min.length; i ++) {
			Min[i] = i + 1;
		}
		
		Min[0] = 0;
		for (int i = 1; i <= S; i ++) {
			for (int j = 0; j < N.length; j ++) {
				if (N[j] <= i && Min[i - N[j]] + 1 < Min[i]) {
					Min[i] = Min[i - N[j]] + 1;
					System.out.println("Min[" + i + "] = " + Min[i]);
				}
				
			}
		}
		System.out.println("Min[" + 11 + "] = " + Min[11]);	
	}

}
