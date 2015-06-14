package Algorithms;

public class InsertionSort {
	static void insertion_sort(int[] a,int n){
		int key,i,j;
		for(j=1;j<n;j++){
			key=a[j];
			i=j-1;
			while(i>=0&&a[i]>key){
				a[i+1]=a[i];
				i--;
			}
			a[i+1]=key;
		}
	}
	public static void main(String[] args) {
		int[] a={5,2,4,6,1,3};
		int n=a.length;
		insertion_sort(a,n);
		print(a,n);
	}
	static void print(int[] a,int n){
		int i;
		for(i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}
