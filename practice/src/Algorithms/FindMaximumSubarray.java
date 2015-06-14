package Algorithms;

public class FindMaximumSubarray {
	static int[] find_maximum_subarray(int[] a,int low,int high){
		if(low==high)
			return new int[]{low,high,a[low]};
		int mid=low+(high-low)/2;
		int[] left=find_maximum_subarray(a,low,mid);
		int[] right=find_maximum_subarray(a, mid+1, high);
		int[] cross=find_max_crossing_subarray(a,low,mid,high);
		if(left[2]>=right[2]&&left[2]>=cross[2])
			return left;
		if(right[2]>=left[2]&&right[0]>=cross[2])
			return right;
		return cross;
	}
	static int[] find_max_crossing_subarray(int[] a,int low,int mid,int high){
		int i,left_sum=Integer.MIN_VALUE,sum,max_left=0;
		sum=0;
		for(i=mid;i>=low;i--){
			sum+=a[i];
			if(sum>left_sum){
				left_sum=sum;
				max_left=i;
			}
		}
		int right_sum=Integer.MIN_VALUE,max_right=0;
		sum=0;
		for(i=mid+1;i<=high;i++){
			sum+=a[i];
			if(sum>right_sum){
				right_sum=sum;
				max_right=i;
			}
		}
		return new int[]{max_left,max_right,left_sum+right_sum};
	}
	public static void main(String[] args) {
		int[] a=new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		int n=a.length;
		int[] res=find_maximum_subarray(a, 0, n-1);
		System.out.println(res[0]+"-"+res[1]+":"+res[2]);
	}

}
