package com.srikanth.gs;

public class StairCase {

	public static void main(String[] args) {
		for(int i=0;i<40;i++){
		System.out.println(stairCaseMem(i));
		}
		for(int i=0;i<35;i++){
			System.out.println(stairCase(i));
			}
	}
	
	public static int stairCase(int n){
		if(n<=0){
			return 1;
		}else if(n==1){
			return 1;
		}else if(n==2){
			return 2;
		}
		return stairCase(n-1)+stairCase(n-2)+stairCase(n-3);
	}
	
	public static int stairCaseMem(int n){
		if(n<=0 || n==1){
			return 1;
		}else if(n==2){
			return 2;
		}else{
			int[] a = new int[n+1];
			a[0] = 1;
			a[1] = 1;
			a[2] = 2;
			for(int i=3;i<=n;i++){
				a[i] = a[i-1]+a[i-2]+a[i-3];
			}
			return a[n];
		}
		
	}

}
