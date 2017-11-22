package com.srikanth.gs;

import java.util.Set;
import java.util.TreeSet;

public class SecondSmallestNumberTest {

	public static void main(String[] args) {
		int[] arr = {1,6,3,4,6,7,8,-1,6,3,2,7,4,7,10,-3,9};
		Set<Integer> set = new TreeSet<>();
		for(int i=0;i<arr.length;i++){
			set.add(arr[i]);
		}
		
		System.out.println(set.toArray()[set.size()-2]);
	}

}
