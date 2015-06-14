package Mathematical;

public class PrintCompositions {
	static int[] arr = new int[1000];
	static void printCompositions(int n, int i) {
		if (n == 0) {
			printArray(arr, i);
		} else if (n > 0) {
			for (int k = 1; k <= 3; k ++) {
				arr[i] = k;
				printCompositions(n - k, i + 1);
			}
		}
	}
	static void printArray(int[] arr, int i) {
		for (int j = 0; j < i; j ++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int n = 5;
		printCompositions(n, 0);
	}

}
