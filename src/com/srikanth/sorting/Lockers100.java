package com.srikanth.sorting;

public class Lockers100 {

	public static void main(String[] args) {
		int[] arrLockers = new int[100+1];
		for(int k=0;k<=100;k++){
			arrLockers[k] = 1;
		}
		
		for(int j=2;j<=100;j++){
			for(int i=0;i<=100;i=j+i){
				if(arrLockers[i]==0){
					arrLockers[i] =1;
				}else{
					arrLockers[i] =0;
				}
			}
		}
		int sum =0;
		for(int i=1;i<=100;i++){
			if(arrLockers[i]==1){
				System.out.println("Locker opened is "+i);
				sum++;	
			}
		}
		System.out.println(sum);

	}

}
