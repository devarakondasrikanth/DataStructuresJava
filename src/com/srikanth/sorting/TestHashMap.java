package com.srikanth.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TestHashMap {

	public static void main(String[] args) {
		Map<String,Employee> hMap = new HashMap<String,Employee>();
		hMap.put("srikanth",new Employee("Srikanth"));
		hMap.put(null, null);
		hMap.put(null, null);
		hMap.put(null, null);
		hMap.put(null, null);
		hMap.put(null, null);
		hMap.put(null, null);
		hMap.put(null, null);
		
		System.out.println(hMap.get(null));
		String str = "http://hudson.ris.principal.com/hudson/job/RISPRTCP/job/integration-participantinvestment/2741/";
		System.out.println(str.split("/")[5]);
	}
	
	public static int[] balanced(String[] s,int[] t){
		int[] result = new int[s.length];
		for(int i=0;i<s.length;i++){
			char[] temp = s[i].toCharArray();
			Stack stack = new Stack();
			int count =0;
			for(int j=0;j<temp.length;j++){
				if(temp[j]=='<'){
					stack.push(temp[j]);
				}else if(temp[j] == '>' && !stack.isEmpty()){
					stack.pop();
				}else{
					count++;
				}				
			}
			if(!stack.isEmpty() && count > 0 && t[i] != count){
				result[i] = 1;
			}else{
				result[i] = 0;
			}
		}
		return result;
	}

}
