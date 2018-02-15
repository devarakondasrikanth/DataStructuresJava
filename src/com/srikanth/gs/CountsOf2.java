package com.srikanth.gs;

public class CountsOf2 {

	public static void main(String[] args) {
		System.out.println(countsof2(12));
		System.out.println(countsofKDigit(100,9));
	}
	//from 1 to n
	public static int countsof2(int n){
		int count = 0;
		for(int i=1;i<=n;i++){
			if(i==2){
				count++;
			}else{
				int temp =i;
				while(temp>0){
					if(temp%10==2){
						count++;
					}
					temp = temp/10;
				}
			}
		}
		return count;
	}
	
		//from 1 to n
		public static int countsofKDigit(int n,int k){
			int count = 0;
			for(int i=1;i<=n;i++){
				if(i==k){
					count++;
				}else{
					int temp =i;
					while(temp>0){
						if(temp%10==k){
							count++;
						}
						temp = temp/10;
					}
				}
			}
			return count;
		}
}
