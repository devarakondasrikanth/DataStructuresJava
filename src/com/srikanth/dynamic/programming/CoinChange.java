package com.srikanth.dynamic.programming;

import java.util.Arrays;

public class CoinChange {
	
	public static void main(String args[]){
		int arr[] = {1, 2, 3};
        for(int n=1;n<=10;n++){
        System.out.println(countWays(n,arr));        
        System.out.println(coinChnageWays(n,arr));
        }
        
        
	}
	
	public static int countWays(int n,int[] arr){
		int[] ways = new int[n+1];
		Arrays.fill(ways, 0);
		ways[0] =1;
		for(int i=0;i<arr.length;i++){
			for(int j=arr[i];j<=n;j++){
				ways[j]+=ways[j-arr[i]];
			}
		}
		return ways[n];
	}
	
	
	public static int coinChnageWays(int amount,int[] coins){
		int[] combinations = new int[amount+1];
		combinations[0] = 1;
		for(int coin:coins){
			for(int i=1;i<combinations.length;i++){
				if(i>=coin){
					combinations[i]+=combinations[i-coin];
				}
				System.out.print(combinations[i]+" ");
			}
			System.out.println();
		}
		
		return combinations[amount];
	}
}
