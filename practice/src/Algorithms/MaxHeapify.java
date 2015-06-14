package Algorithms;

public class MaxHeapify {
	static void max_heapify(int[] a,int i,int n){
		int l=i<<1,r=l+1,largest,t;
		if(l<n&&a[l]>a[i])
			largest=l;
		else
			largest=i;
		if(r<n&&a[r]>a[largest])
			largest=r;
		
		if(largest!=i){
			t=a[i];
			a[i]=a[largest];
			a[largest]=t;
			max_heapify(a,largest,n);
		}
	}
	static void build_max_heap(int[] a,int n){
		int i;
		for(i=n/2;i>=1;i--)
			max_heapify(a,i,n);
	}
	static void heap_sort(int[] a,int n){
		build_max_heap(a, n);
		int i,t;
		for(i=n-1;i>=2;i--){
			t=a[1];
			a[1]=a[i];
			a[i]=t;
			max_heapify(a, 1, i);
		}
	}
	static void print(int[] a,int n){
		int i;
		for(i=1;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a={5,3,17,10,84,19,6,22,9};
		//int[] a={0,4,1,3,2,16,9,10,14,8,7};
		int n=a.length;
		heap_sort(a,n);
		print(a,n);
	}

}
