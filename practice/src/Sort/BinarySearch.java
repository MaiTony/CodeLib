package Sort;

public class BinarySearch {

	public static void main(String[] args) {
		int[]arr={2,3,4,10,40};
		System.out.println(bs(arr,0,arr.length-1,10));
		System.out.println(bs(arr,0,arr.length-1,5));
		
	}
	
	static int bs(int arr[],int l,int r,int x){
		if(l<r){
			int mid=l+(r-l)/2;
			if(arr[mid]==x) return mid;
			if(arr[mid]<x)
				return bs(arr,mid+1,r,x);
			else
				return bs(arr,l,mid-1,x);
		}
		return -1;
	}
}
