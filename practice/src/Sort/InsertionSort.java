package Sort;

public class InsertionSort {

	public static void main(String[] args) {
		int[]arr={12, 11, 13, 5, 6};
		is(arr);
		printArray(arr);
	}
	static void is(int[]arr){
		int i,j,key,n=arr.length;
		for(i=1;i<n;i++){
			key=arr[i];
			j=i-1;
			while(j>=0&&arr[j]>key){
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
	}
	static void printArray(int[]arr){
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
	}
}
