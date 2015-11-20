package CodigoAulas.heaps;

import static CodigoAulas.heaps.Heap.*;

public class TestHeaps {
	static int pos = 0;

	public static void main(String[] args) {
		int[] table = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		int[] table2 = {4, 3, 5, 2, 16, 9, 10, 14, 8, 7};
		
		maxHeapify(table, 1, table.length);
		show(table);
		buildMaxHeap(table2, table2.length);
		show(table);
	}

	public static void show(int[] t) {
		for (int i = 0; i < t.length; i++)
			System.out.print(t[i] + " ");
		System.out.println();
	}
}
