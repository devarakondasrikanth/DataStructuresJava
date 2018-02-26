package com.srikanth.graphs;

import java.util.HashSet;
import java.util.Set;

public class GraphTest {

	public static void main(String[] args) {
		Graph g = new Graph();
		Set<Integer> set0 = new HashSet<>();
		set0.add(1);
		set0.add(4);
		g.add(0, set0);
		Set<Integer> set1 = new HashSet<>();
		set1.add(0);
		set1.add(4);
		set1.add(2);
		set1.add(3);		
		g.add(1, set1);
		Set<Integer> set2 = new HashSet<>();
		set2.add(1);
		set2.add(3);
		g.add(2, set2);
		Set<Integer> set3 = new HashSet<>();
		set3.add(1);
		set3.add(4);
		set3.add(2);
		g.add(3, set3);
		Set<Integer> set4 = new HashSet<>();
		set4.add(3);
		set4.add(0);
		set4.add(1);
		g.add(4, set4);
		g.addVertexAndEdge(5, 4);
		g.printGraph();
		
		g.Bfs();

	}

}
