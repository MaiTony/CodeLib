package Algorithms;

public class CountingSort {

	static int[] counting_sort(int[] a,int n,int k){
		int[] b=new int[n],c=new int[k+1];
		int i;
		for(i=0;i<n;i++)
			c[a[i]]++;
		for(i=1;i<=k;i++)
			c[i]+=c[i-1];
		for(i=n-1;i>=0;i--){
			b[c[a[i]]-1]=a[i];
			c[a[i]]--;
		}
		return b;
	}
	static void print(int[] a,int n){
		int i;
		for(i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		//int[] a={2,5,3,0,2,3,0,3};
		int[] a={6,0,2,0,1,3,4,6,1,3,2};
		int n=a.length;
		a=counting_sort(a, n, 6);
		print(a, n);
	}

}
