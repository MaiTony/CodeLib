package Sort;

public class HeapSort {
	public static void main(String[] args) {
		int[]arr={12, 11, 13, 5, 6, 7};
		hs(arr);
		printArray(arr);
	}
	static void printArray(int[]arr){
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
	}
	static class MaxHeap{
		int size;
		int[]array;
	}
	static void hs(int[]array){
		MaxHeap maxHeap=createAndBuildheap(array,array.length);
		
		while(maxHeap.size>1){
			swap(maxHeap,0,maxHeap.size-1);
			maxHeap.size--;
			maxHeapify(maxHeap, 0);
		}
	}
	static MaxHeap createAndBuildheap(int[]array,int size){
		MaxHeap maxHeap=new MaxHeap();
		maxHeap.size=size;
		maxHeap.array=array;
		for(int i=size/2-1;i>=0;i--){
			maxHeapify(maxHeap,i);
		}
		return maxHeap;
	}
	static void maxHeapify(MaxHeap maxHeap,int idx){
		int largest=idx;
		int left=idx*2+1;
		int right=idx*2+2;
		
		if(left<maxHeap.size&&maxHeap.array[left]>maxHeap.array[largest])
			largest=left;
		if(right<maxHeap.size&&maxHeap.array[right]>maxHeap.array[largest])
			largest=right;
		
		if(largest!=idx){
			swap(maxHeap,largest,idx);
			maxHeapify(maxHeap, largest);
		}
	}
	static void swap(MaxHeap maxHeap,int i,int j){
		int t=maxHeap.array[i];
		maxHeap.array[i]=maxHeap.array[j];
		maxHeap.array[j]=t;
	}
}
