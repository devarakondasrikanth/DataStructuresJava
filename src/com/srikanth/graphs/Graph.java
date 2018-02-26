package com.srikanth.graphs;


import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph {
	
	private Map<Integer,LinkedList<Integer>> map;
	
	Graph(){
		this.map = new LinkedHashMap<>();
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
	
	public void addVertexAndEdge(int val,int edge){
		if(!map.containsKey(val)){
			LinkedList<Integer> linkedList = new LinkedList<>();
			
				linkedList.add(edge);
			
			this.map.put(val, linkedList);
		}else{
			LinkedList<Integer> linkedList = this.map.get(val);			
			linkedList.add(edge);
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
	
	public void Bfs(){
			Set<Integer> visited = new HashSet<>();
			printGraphNodeInBFS(this.map,visited);
			if(this.map.size()==visited.size()){
				System.out.print("All nodes visited");
			}
	}
	
	private void printGraphNodeInBFS(Map<Integer,LinkedList<Integer>> map,Set<Integer> visted){
		Set<Integer> set = map.keySet();
		for(int k:set){
			LinkedList<Integer> temp = this.map.get(k);
			if(!visted.contains(k)){
				System.out.println("Visited Node"+k);
				visted.add(k);
			}
			Iterator<Integer> it = temp.iterator();
			while(it.hasNext()){
				int v= it.next();
				if(!visted.contains(v)){
					System.out.println("Visited Node"+v);
					visted.add(v);
				}
			}
			System.out.println("Visiting nodes after key "+k+" is "+visted.toString());
		}
	}
	
}
