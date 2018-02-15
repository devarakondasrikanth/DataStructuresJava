package com.srikanth.gs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StringPermutations {
	public static void main(String args[]){
		//permutation("SRIKANTH");
		Set<String> lst = permutations("SRIKANTH");
		for(String str:lst)
			System.out.println(str);
		System.out.println(lst.size());
	}
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) {
	    	System.out.println(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	public static Set<String> permutations(String str){
		Set<String> lst = new HashSet<>();
		if(str == null){
			return lst;
		}else{
			permute(str,0,str.length()-1,lst);
			return lst;
		}
	}

	public static void permute(String str,int l,int r,Set<String> lst){
		if(l==r){
			if(!lst.contains(str))
			lst.add(str);
		}else{
		for(int i=0;i<str.length();i++){
			str= swap(str,l,i);
			permute(str,l+1,r,lst);
			str= swap(str,l,i);
			}
		}
	}

	public static String swap(String str,int i,int j){
		char[] tempArr = str.toCharArray();
		char temp = tempArr[i];
		tempArr[i] = tempArr[j];
		tempArr[j] = temp;
		return String.valueOf(tempArr);
	}
}
