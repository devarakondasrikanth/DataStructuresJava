package com.srikanth.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph {
	
	private Map<Integer,LinkedList<Integer>> map;
	
	Graph(){
		this.map = new HashMap<>();
	}
	
	public void add(int val,Set<Integer> edges){
		if(!map.containsKey(val)){
			LinkedList<Integer> linkedList = new LinkedList<>();
			for(int edge:edges){
				linkedList.add(edge);
			}
			this.map.put(val, linkedList);
		}else{
			LinkedList<Integer> linkedList = this.map.get(val);
			for(int edge:edges){
				linkedList.add(edge);
			}
			this.map.put(val, linkedList);
		}
	}
	
	public void printGraph(){
		Set<Integer> set = this.map.keySet();
		for(int k:set){
			LinkedList<Integer> l = this.map.get(k);
			System.out.println("Edges for the "+k);
			l.forEach(System.out::print);
			System.out.println();
			System.out.println("************");
		}
	}
	

}
