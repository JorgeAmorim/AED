package CodigoAulas.heapsQueues;

import static CodigoAulas.heapsQueues.PriQueue.*;

public class TestPriQueues {
	static int pos = 0;

	public static void main(String[] args) {
		int[] table = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
		
		int size = table.length;
		System.out.println(maximum(table, size));
		System.out.println(extractMax(table, size));
		size -= 1;
		showHeap(table, size);
		maxHeapInsert(table, size, 16);
		size += 1;
		showHeap(table, size);
		increaseKey(table, size, 3, 15);
		showHeap(table, size);
	}

	public static void showHeap(int[] h, int n) {
		for (int i = 0; i < n; i++)
			System.out.print(h[i] + " ");
		System.out.println();
	}
}
