package com.srikanth.sorting;

public class Lockers100 {

	public static void main(String[] args) {
		lockers(1000);
		
	}
	
	public static void lockers(int n){
		int[] arrLockers = new int[n+1];
		for(int k=0;k<=n;k++){
			arrLockers[k] = 1;
		}
		
		for(int j=2;j<=n;j++){
			for(int i=0;i<=n;i=j+i){
				if(arrLockers[i]==0){
					arrLockers[i] =1;
				}else{
					arrLockers[i] =0;
				}
			}
			//printArray(arrLockers);
			
		}
		int sum =0;
		for(int i=1;i<=n;i++){
			if(arrLockers[i]==1){
				//System.out.println("Locker opened is "+i);
				sum++;	
			}
		}
		System.out.println(sum);

	}
	public static void printArray(int[] a){
		for(int i:a){
			System.out.print(i+"\t");
		}
		System.out.println();
	}
	public static int countSquares(int a, int b)
    {
        int cnt = 0; // Initialize result
 
        // Traverse through all numbers
        for (int i=a; i<=b; i++)
 
            // Check if current number 'i' is perfect
            // square
            for (int j=1; j*j<=i; j++)
                if (j*j==i)
                    cnt++;
        return cnt;
    }

}
