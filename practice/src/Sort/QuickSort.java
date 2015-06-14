package Sort;


public class QuickSort {

	public static void main(String[] args) {
		int[] arr={10,7,8,9,1,5};
		int n=arr.length;
		quickSort(arr,0,n-1);
		printArray(arr,n);
	}
	static void printArray(int[] arr,int n){
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	static void quickSort(int[] arr,int l,int h){
		int p=partition(arr,l,h);
		if(l<p-1)
			quickSort(arr,l,p-1);
		if(p<h)
			quickSort(arr,p,h);
	}
	static int partition(int[] arr,int l,int h){
		int x=arr[(l+h)/2];
		int i=l,j=h;
		while(i<=j){
			while(arr[i]<x) i++;
			while(arr[j]>x) j--;
			if(i<=j){
				swap(arr,i,j);
				i++;
				j--;
			}
		}
		return i;
	}
	static void swap(int[] arr,int i,int j){
		int t=arr[i];
		arr[i]=arr[j];
		arr[j]=t;
	}
}
