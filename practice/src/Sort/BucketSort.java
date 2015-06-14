package Sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
	public static void main(String[] args) {
		double[]arr={0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
		bs(arr);
		printArray(arr);
	}
	static void bs(double[]arr){
		ArrayList<ArrayList<Double>> b=new ArrayList<ArrayList<Double>>();
		int i,j,n=arr.length;
		for(i=0;i<n;i++)
			b.add(new ArrayList<Double>());
		for(i=0;i<n;i++){
			j=(int)Math.round(n*arr[i]);
			b.get(j).add(arr[i]);
		}
		for(i=0;i<n;i++)
			if(b.get(i).size()>1)
				Collections.sort(b.get(i));
		j=0;
		for(i=0;i<n;i++){
			for(double e:b.get(i))
				arr[j++]=e;
		}
	}
	static void printArray(double[]arr){
		for(double i:arr)
			System.out.print(i+" ");
		System.out.println();
	}

}
