package Algorithms;

public class MergeSort {
	static void merge_sort(int[] a,int p,int r){
		int q;
		if(p<r){
			q=p+(r-p)/2;
			merge_sort(a, p, q);
			merge_sort(a, q+1, r);
			merge(a,p,q,r);
		}
	}
	static void merge(int[] a,int p,int q,int r){
		int i,j,k,n1,n2;
		n1=q-p+1;
		n2=r-q;
		int[] L=new int[n1+1],R=new int[n2+1];
		for(i=0;i<n1;i++)
			L[i]=a[p+i];
		for(i=0;i<n2;i++)
			R[i]=a[q+i+1];
		L[n1]=Integer.MAX_VALUE;
		R[n2]=Integer.MAX_VALUE;
		i=0;
		j=0;
		for(k=p;k<=r;k++){
			if(L[i]<=R[j]){
				a[k]=L[i];
				i++;
			}else{
				a[k]=R[j];
				j++;
			}
		}
	}
	static void print(int[] a,int n){
		int i;
		for(i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a={5,2,4,7,1,3,2,6};
		int n=a.length;
		merge_sort(a, 0, n-1);
		print(a,n);
	}
}
