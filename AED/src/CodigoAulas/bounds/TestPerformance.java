package CodigoAulas.bounds;

public class TestPerformance {
	
	/* 	Gera numeros n números aleatórios sem repetição entre min e max */
	public static int[] makeSet(int n, int min, int max) { 
		if (n > max - min + 1) n = max - min + 1;
		int[] res = new int[n], aux = new int[max-min+1]; 
		for (int j = 0; j < aux.length; j++) aux[j] = min + j;
		int j = aux.length;
		for (int i = 0; i < res.length; i++) {
			int num = (int) Math.floor((Math.random() * j));
			res[i] = aux[num];
			j--;
			aux[num] = aux[j];
		}
		return res;
	}
	
	public static void show(int[] t) {
		for (int i = 0; i < t.length; i++)
			System.out.print(t[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = makeSet(10000000, -10000000, 10000000); 
		int min = -100, max = 100;
		int res; long start, elapsedTime;
		
		MergeSort.mergeSort(a); 
		//show(a);
		System.out.println("min = " + min + " max = " + max);
		
		start = System.nanoTime();
		res = LowerAndUpperBounds.distanceBetweenLinear(a, 0, a.length-1, min, max);
		elapsedTime = System.nanoTime() - start;
		System.out.println("DB linear = " + res + " time = " + elapsedTime * 1e-6);
		
		start = System.nanoTime();
		res = LowerAndUpperBounds.distanceBetweenBinary(a, 0, a.length-1, min, max);
		elapsedTime = System.nanoTime() - start;
		System.out.println("DB binary = " + res + " time = " + elapsedTime * 1e-6);
	}

}
