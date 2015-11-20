package CodigoAulas.sort;

import static CodigoAulas.sort.MergeSort.mergeSort;
import static java.lang.System.nanoTime;

public class TestPerformanceSort {

	public static void main(String[] args) {
		int[] table, unsortTable;
		long start, elapsedTime;

		unsortTable = makeSet(100000, 0, 100000);
		table = new int[unsortTable.length];
		
		arrayCopy(unsortTable, table);
		//show(table);
		start = nanoTime();
		BubbleSort.bubbleSort(table, 0, table.length - 1);
		elapsedTime = nanoTime() - start;
		System.out.println("Bubble Sort time = " + elapsedTime * 1e-9 + " s \n");
		//show(table);

		arrayCopy(unsortTable, table);
		start = nanoTime();
		BubbleSort.bubbleSortImproved(table, 0, table.length - 1);
		elapsedTime = nanoTime() - start;
		System.out.println("Bubble Sort (improved) time = " + elapsedTime * 1e-9 + " s \n");
		
		arrayCopy(unsortTable, table);
		start = nanoTime();
		SelectionSort.selectionSort(table, 0, table.length - 1);
		elapsedTime = nanoTime() - start;
		System.out.println("Selection Sort time = " + elapsedTime * 1e-9 + " s \n");
		
		arrayCopy(unsortTable, table);
		start = nanoTime();
		InsertionSort.insertionSort(table, 0, table.length - 1);
		elapsedTime = nanoTime() - start;
		System.out.println("Insertion Sort time = " + elapsedTime * 1e-9 + " s \n");

		arrayCopy(unsortTable, table);
		start = nanoTime();
		InsertionSort.insertionSortImproved(table, 0, table.length - 1);
		elapsedTime = nanoTime() - start;
		System.out.println("Insertion Sort time (improved) = " + elapsedTime * 1e-9 + " s \n");
		
		arrayCopy(unsortTable, table);
		start = nanoTime();
		mergeSort(table);
		elapsedTime = nanoTime() - start;
		System.out.println("Merge Sort time = " + elapsedTime * 1e-9 + " s \n");
		//show(table);
	}
	
	/* 	Gera n números aleatórios entre min e max */
	public static int[] makeSet(int n, int min, int max) { 
		int[] res = new int[n];
		for (int i = 0; i < res.length; i++)
			res[i] = (int) Math.floor((Math.random() * (max - min + 1)) + min);
		return res;
	}
	
	public static void arrayCopy(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++)
			b[i] = a[i];
	}

	public static void show(int[] t) {
		for (int i = 0; i < t.length; i++)
			System.out.print(t[i] + " ");
		System.out.println();
	}

}
