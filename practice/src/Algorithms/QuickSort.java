package Algorithms;

public class QuickSort {

	static void quick_sort(int[] a,int p,int r){
		if(p<r){
			int q=partition(a,p,r);
			quick_sort(a,p,q-1);
			quick_sort(a,q+1,r);
		}
	}
	static int partition(int[] a,int p,int r){
		int x=a[r],i=p-1,j,t;
		for(j=p;j<r;j++){
			if(a[j]<=x){
				i++;
				t=a[j];
				a[j]=a[i];
				a[i]=t;
			}
		}
		t=a[i+1];
		a[i+1]=a[r];
		a[r]=t;
		
		return i+1;
	}
	static void print(int[] a,int n){
		int i;
		for(i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a={2,8,7,1,3,5,6,4};
		int n=a.length;
		quick_sort(a,0,n-1);
		print(a, n);
	}

}
