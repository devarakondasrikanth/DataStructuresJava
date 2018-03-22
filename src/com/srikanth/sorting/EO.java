package com.srikanth.sorting;

public class EO {
	static boolean isOddPrinted = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable odd = () -> {

			for (int i = 1; i < 200;) {
				if (EO.isOddPrinted) {
					System.out.println(i + "---->" + Thread.currentThread().getName());
					EO.isOddPrinted = !EO.isOddPrinted;
					i = i + 2;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Runnable even = () -> {

			for (int i = 2; i < 200;) {
				if (!EO.isOddPrinted) {
					System.out.println(i + "---->" + Thread.currentThread().getName());
					EO.isOddPrinted = !EO.isOddPrinted;
					i = i + 2;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Thread t1 = new Thread(odd, "ODD Thread");
		Thread t2 = new Thread(even, "Even Thread");
		t1.start();
		t2.start();
	}

}
