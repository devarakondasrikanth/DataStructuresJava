package com.srikanth.gs;

public class MaxSumInArray {

	public static void main(String[] args) {
		int a[]={-2,-3,4,-1,-2,1,5,-3};
		System.out.println(maxSumInArray(a));
	}
	
	public static int maxSumInArray(int[] arr){
		if(arr==null){
			return 0;
		}else{
			int max_sum = Integer.MIN_VALUE;
			int curr_max = arr[0];
			for(int i=1;i<arr.length;i++){
			curr_max = Math.max(arr[i],arr[i]+curr_max);
			max_sum = Math.max(max_sum,curr_max);
			}
			return max_sum;
		}
	}

}
