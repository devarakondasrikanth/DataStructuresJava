package com.srikanth.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	
	public static int[] MSort(int[] arr){
		if(arr==null){
			return null;
		}else if(arr.length == 1){
			return arr;
		}else{
			int midPoint = arr.length/2;
			int[] left = new int[midPoint];
			int[] right = new int[arr.length -midPoint];
			for(int i=0;i<midPoint;i++){
				left[i] = arr[i];
			}
			for(int j =0; j<arr.length-midPoint; j++){
				right[j] = arr[midPoint+j];
			}
			left = MSort(left);
			right = MSort(right);
			return merge(left,right);
		}
		
	}
	
	public static int[] merge(int[] left,int[] right){
		int lIndex = 0;
		int rIndex =0;
		List<Integer> lst = new ArrayList<>();
		while(lIndex<left.length&&rIndex<right.length){			
			if(left[lIndex]<right[rIndex]){
				lst.add(left[lIndex++]);
			}else if(left[lIndex]>right[rIndex]){
				lst.add(right[rIndex++]);
			}else{
				lst.add(left[lIndex++]);
				rIndex++;
			}
		}
		
		while(lIndex<left.length){
			lst.add(left[lIndex++]);
		}
		while(rIndex<right.length){
			lst.add(right[rIndex++]);
		}
		int[] returnArray = new int[lst.size()];
		int temp =0;
		for(int i : lst){
			returnArray[temp++] = i;
		}
		return returnArray;
	}
	
	public static int[] QuickSort(int[] arr){
		if(arr == null){
			return null;
		}else if(arr.length == 1){
			return arr;
		}else{
			QS(arr,0,arr.length-1);
			return arr;
		}
	}
	
	public static void QS(int[] arr,int lIndex,int rIndex){
		int i=lIndex;
		int j=rIndex;
		int pivotal = arr[(lIndex+(rIndex-lIndex)/2)];
		while(i<=j){
			
			while(arr[i]<pivotal){
				i++;
			}
			while(arr[j]>pivotal){
				j--;
			}
			if(i<=j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
			
		}		
		if(lIndex<j)
		QS(arr,lIndex,j);
		if(i<rIndex)
		QS(arr,i,rIndex);
	}
	
	public static int[] insertionSort(int[] arr){
		if(arr==null){
			return arr;
		}else if(arr.length==1){
			return arr;
		}else{
			int key =0,j=0;
			for(int i=1;i<arr.length;i++){
				key = arr[i];
				j = i-1;
				while(j>=0&&arr[j]>key){
					arr[j+1]= arr[j];
							j--;
				}
				arr[j+1]= key;
			}
			return arr;
		}
	}

	public static int[] bubbleSort(int[] arr){
		if(arr==null){
			return arr;
		}else if(arr.length==1){
			return arr;
		}else{
			for(int i=0;i<arr.length;i++){
				for(int j=1;j<arr.length-i;j++){
					if(arr[j-1]>arr[j]){
						int temp =arr[j-1];
						arr[j-1] = arr[j];
						arr[j] = temp;
					}
				}
			}
			return arr;
		}
	}
	
	public static void main(String args[]){
		int[] a = {1,8,2,3,7,4,9,5,6};
		a = bubbleSort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

}
