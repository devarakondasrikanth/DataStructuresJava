package com.srikanth.dynamic.programming;

public class LargestSumContiguousSubarray {

	public static void main(String[] args) {		 
		int[] a ={-2,-3,-4,-1,3,3,1,-3};
		System.out.println("Sum of contiguous array is "+maxSum(a));
	}
	/* corner cases are not handled */
	public static int maxSum(int[] arr){
		int max_so_far = 0;
		int max_ending_here =0;
		int startIndex =0;
		int endIndex =0;
		int s =0;
		for(int i=0;i<arr.length;i++){
			max_ending_here = max_ending_here+arr[i];
			if(max_ending_here<0){
				max_ending_here = 0;
				s =i+1;
			}
			if(max_so_far < max_ending_here){
				max_so_far = max_ending_here;
				startIndex =s;
				endIndex =i;
			}
		}
		System.out.println("*******************");
		System.out.println("Printing sub Array");
		System.out.println("*******************");
		for(int k = startIndex;k<=endIndex;k++){
			System.out.print(" "+arr[k]);
		}
		System.out.println();
		return max_so_far;
	}
	
	public static int maxSumCorner(int[] arr){
		int max_so_far =0;
		int cur_max =0;
		for(int i=0;i<arr.length;i++){
			cur_max = Math.max(arr[i], cur_max+arr[i]);
			max_so_far = Math.max(max_so_far, cur_max);
		}
		return max_so_far;
	}
	
	public int longestIncreasingPath(int[][] matrix) {

		if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
			return 0;

		int max = 0, n = matrix.length, m = matrix[0].length;

		// create a cache matrix
		int[][] cache = new int[n][m];

		// dfs search on every element in matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(dfs(matrix, Integer.MIN_VALUE, i, j, n, m, cache), max);
			}
		}
		return max;
	}

	int dfs(int[][] matrix, int min, int i, int j, int n, int m, int[][] cache) {

		// check boundary limits
		if (i < 0 || j < 0 || i >= n || j >= m)
			return 0;

		// check min condition
		if (matrix[i][j] <= min)
			return 0;

		// check into cache
		if (cache[i][j] != 0)
			return cache[i][j];

		// update min
		min = matrix[i][j];

		// run dfs in all four directions
		int a = dfs(matrix, min, i - 1, j, n, m, cache) + 1;
		int b = dfs(matrix, min, i + 1, j, n, m, cache) + 1;
		int c = dfs(matrix, min, i, j - 1, n, m, cache) + 1;
		int d = dfs(matrix, min, i, j + 1, n, m, cache) + 1;

		// find max and update cache
		int max = Math.max(a, Math.max(b, Math.max(c, d)));
		cache[i][j] = max;

		return max;
	}

}
