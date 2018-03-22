package com.srikanth.gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ArrayListCombinations {

	public static void main(String[] args) {
		
		List<Integer> l1 = Arrays.asList(1,2,3);
	    List<Integer> l2 = Arrays.asList(4,5);
	    List<Integer> l3 = Arrays.asList(6,7);
	    List<Integer> l4 = Arrays.asList(8,9,10);

	    List<List<Integer>> lists = new ArrayList<List<Integer>>();
	    lists.add(l1);
	    lists.add(l2);
	    lists.add(l3);
	    lists.add(l4);
	    lists.add(l1);
	    lists.add(l2);
	    lists.add(l3);
	    lists.add(l4);
	    lists.add(l1);
	    lists.add(l2);
	    lists.add(l3);
	    lists.add(l4);
	    lists.add(l1);
	    lists.add(l2);
	    lists.add(l3);
	    lists.add(l4);

	   /* Set<List<Integer>> combs = getCombinations(lists);
	    for(List<Integer> list : combs) {
	        System.out.println(list.toString());
	    }*/
	    
	    List<List<Integer>> lis = computeCombinations2(lists);
	    for(List<Integer> list : lis) {
	        System.out.println(list.toString());
	    }
	}
	
	public static <T> Set<List<T>> getCombinations(List<List<T>> lists) {
	    Set<List<T>> combinations = new HashSet<List<T>>();
	    Set<List<T>> newCombinations;

	    int index = 0;

	    // extract each of the integers in the first list
	    // and add each to ints as a new list
	    for(T i: lists.get(0)) {
	        List<T> newList = new ArrayList<T>();
	        newList.add(i);
	        combinations.add(newList);
	    }
	    index++;
	    while(index < lists.size()) {
	        List<T> nextList = lists.get(index);
	        newCombinations = new HashSet<List<T>>();
	        for(List<T> first: combinations) {
	            for(T second: nextList) {
	                List<T> newList = new ArrayList<T>();
	                newList.addAll(first);
	                newList.add(second);
	                newCombinations.add(newList);
	            }
	        }
	        combinations = newCombinations;

	        index++;
	    }

	    return combinations;
	}
	
	public static <T> List<List<T>> computeCombinations2(List<List<T>> lists) {
	    List<List<T>> combinations = Arrays.asList(Arrays.asList());
	    for (List<T> list : lists) {
	        List<List<T>> extraColumnCombinations = new ArrayList<>();
	        for (List<T> combination : combinations) {
	            for (T element : list) {
	                List<T> newCombination = new ArrayList<>(combination);
	                newCombination.add(element);
	                extraColumnCombinations.add(newCombination);
	            }
	        }
	        combinations = extraColumnCombinations;
	    }
	    return combinations;
	}
	
	public static <T> Collection<List<T>> permutations(List<Collection<T>> collections) {
		  if (collections == null || collections.isEmpty()) {
		    return Collections.emptyList();
		  } else {
		    Collection<List<T>> res = new ArrayList<>();
		    permutationsImpl(collections, res, 0, new LinkedList<T>());
		    return res;
		  }
		}

		/** Recursive implementation for {@link #permutations(List, Collection)} */
		private static <T> void permutationsImpl(List<Collection<T>> ori, Collection<List<T>> res, int d, List<T> current) {
		  // if depth equals number of original collections, final reached, add and return
		  if (d == ori.size()) {
		    res.add(current);
		    return;
		  }

		  // iterate from current collection and copy 'current' element N times, one for each element
		  Collection<T> currentCollection = ori.get(d);
		  for (T element : currentCollection) {
		    @SuppressWarnings("unchecked")
			List<T> copy = (List<T>) Arrays.asList(current);
		    copy.add(element);
		    permutationsImpl(ori, res, d + 1, copy);
		  }
		}
	
}
