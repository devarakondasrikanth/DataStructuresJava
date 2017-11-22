package com.srikanth.gs;

import java.util.HashMap;
import java.util.Set;

public class MaxSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestSubseq("aabbbbcccdd");
		longestSubseq("11000001");
		longestSubseq("aabbbbcccddbbbbbb77729994789932847888842222888477759993888477577775555555555555");
		
		runLongestIndex("aabbbbcccdd");
		runLongestIndex("11000001");
		runLongestIndex("aabbbbcccddbbbbbb77729994789932847888842222888477759993888477577775555555555555");
	}
	//wont work for duplicates 
	public static int[] longestSubSquence(String str){
		int[] charCount = new int[256];
		char[] charArr = str.toCharArray();
		for(char c :charArr){
			charCount[c]++;
		}
		int max = 0;
		int index =0;
		for(int i=0;i<256;i++){
			if(max<charCount[i]){
				max = charCount[i];
				index = i;
			}
		}
		int startIndex = str.indexOf(index);
		System.out.println(startIndex+"---->"+max);
		return new int[]{startIndex,max};
	}
	//works for all scenarios
	public static int[] longestSubseq(String str){
		HashMap<Integer,Integer> map = new HashMap<>();
		char[] charArr = str.toCharArray();
		for(int i=0;i<charArr.length;){
			int j=0;
			int index_start = i;
			char c = charArr[i];
			while(i<charArr.length && charArr[i]==c){
				i++;
				j++;
			}
			map.put(index_start, j);
		}
		int key = 0;
		int value = 0;
		Set<Integer> set = map.keySet(); 
		for(int in : set){
			if(value<map.get(in)){
				key = in;
				value = map.get(in);
			}
		}
		System.out.println(key+"---->"+value);
		return new int[]{key,value};
	}
	
	public static int[] runLongestIndex(String setofletters) {
		  int maxCount = 0;
		  int maxIndex = 0;

		  // loops each character in the string
		  for (int i = 0; i < setofletters.length() - 1; ) {
		    // new char sequence starts here
		    char currChar = setofletters.charAt(i);
		    int count = 1;
		    int index = i;
		    while ( (index < setofletters.length() - 1) &&
		            (currChar == setofletters.charAt(++index)) ) {
		       count++;
		    } 

		    if (count > maxCount) {
		       maxIndex = i;
		       maxCount = count;
		    }
		    i = index;
		  }
		  System.out.println(maxIndex+"---->"+maxCount);
		  return new int[]{maxIndex,maxCount};
		}
}
