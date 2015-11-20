package CodigoAulas.maxSubArray;

public class TestPerformance {
	
	/* 	Gera numeros n números aleatórios entre min e max */
	public static int[] makeSet(int n, int min, int max) { 
		int[] res = new int[n];
		for (int i = 0; i < res.length; i++)
			res[i] = (int) Math.floor((Math.random() * (max - min + 1)) + min);
		return res;
	}
	
	public static void main(String[] args) {
		//int[] a = {2, 1, -4, 5, 2, -1, 3, -3};
		int[] a = makeSet(100000, -100000, 100000);
		int res; long start, elapsedTime;
		
		start = System.nanoTime();
		res = Kadane.maximumSubArray(a, 0, a.length-1);
		elapsedTime = System.nanoTime() - start;
		System.out.println("Kadane = " + res + " \nTIME = " + elapsedTime * 1e-6 + " ms \n") ;
		
		start = System.nanoTime();
		res = DivideAndConquer.maximumSubArray(a, 0, a.length-1);
		elapsedTime = System.nanoTime() - start;
		System.out.println("Divide & Conquer = " + res + "\nTIME = " + elapsedTime * 1e-6 + " ms \n");
		
		start = System.nanoTime();
		res = BruteForce.maximumSubArray(a, 0, a.length-1);
		elapsedTime = System.nanoTime() - start;
		System.out.println("Brute Force = " + res + "\nTIME = " + elapsedTime * 1e-6 + " ms \n");
	}
}
