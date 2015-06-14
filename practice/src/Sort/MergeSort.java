package Sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr={12,11,13,5,6,7};
		int n=arr.length;
		mergeSort(arr,0,n-1);
		printArray(arr,n);
		
	}
	static void merge(int[] arr,int l,int m,int r){
		int i,j,k,n1=m-l+1,n2=r-m;
		int[] L=new int[n1];
		int[] R=new int[n2];
		System.arraycopy(arr, l, L, 0, n1);
		System.arraycopy(arr, m+1, R, 0, n2);
		i=0;
		j=0;
		k=l;
		while(i<n1&&j<n2){
			if(L[i]<=R[j]){
				arr[k]=L[i];
				i++;
			}else{
				arr[k]=R[j];
				j++;
			}
			k++;
		}
		while(i<n1) arr[k++]=L[i++];
		while(j<n2) arr[k++]=R[j++];
	}
	static void mergeSort(int[] arr,int l,int r){
		if(l<r){
			int m=l+(r-l)/2;
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,r);
			merge(arr,l,m,r);
		}
	}
	static void printArray(int[] arr,int n){
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
