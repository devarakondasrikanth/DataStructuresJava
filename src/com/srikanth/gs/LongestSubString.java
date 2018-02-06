package com.srikanth.gs;

import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String st = "SrikanthdevarakondaSrikanthDevara";
		System.out.println(lSS(st));
	}
	
	public static int lSS(String str){
		int ans =0;
		int n = str.length();
		Set<Character> set = new LinkedHashSet<>();
		int i=0,j=0;
		String tns="";
		while(i<n &&j<n){
			if(!set.contains(str.charAt(j))){
				set.add(str.charAt(j++));
				if(ans<j-i){
					tns = setToString(set);
				}
				ans = Math.max(ans,j-i);
			}else{
				set.remove(str.charAt(i++));
			}
		}		
		System.out.println(tns);
		return ans;
	}
	
	public static String setToString(Set<Character> set){
		String st = "";
		for(char c:set){
			st = st+c;
		}
		return st;
	}

}
