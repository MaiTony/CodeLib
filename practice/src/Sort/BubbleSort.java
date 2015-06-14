package Sort;

public class BubbleSort {

	public static void main(String[] args) {
		int[]arr={64, 34, 25, 12, 22, 11, 90};
		bs(arr);
		printArray(arr);
	}
	static void bs(int[]arr){
		int i,j,n=arr.length;
		for(i=0;i<n;i++){
			for(j=0;j<n-i-1;j++){
				if(arr[j]>arr[j+1])
					swap(arr,j,j+1);
			}
		}
	}
	static void swap(int[]arr,int i,int j){
		int t=arr[i];
		arr[i]=arr[j];
		arr[j]=t;
	}
	static void printArray(int[]arr){
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
	}
}
