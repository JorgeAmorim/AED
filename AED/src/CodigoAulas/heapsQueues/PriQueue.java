package CodigoAulas.heapsQueues;

import java.util.NoSuchElementException;

public class PriQueue {
	
	public static int parent(int i) {
		return (i - 1) / 2;
	}
	
	public static int left(int i) {
		return 2 * i + 1;
	}
	
	public static int right(int i) {
		return 2 * i + 2;
	}
	
	public static int maximum(int[] h, int n) {
		return h[0];
	}
	
	public static int extractMax(int[] h, int n) {
		if (n < 1) throw new NoSuchElementException("Heap underflow");
		int max = h[0];
		n = n - 1;
		exchange(h, 0, n);
		maxHeapify(h, 0, n);
		return max;
	}

	public static void increaseKey(int[] h, int n, int i, int key) {
		if (key < h[i]) throw new NoSuchElementException("Invalid key");
		h[i] = key;
		while (i > 0 && h[parent(i)] < h[i]) {
			exchange(h, i, parent(i));
			i = parent(i);
		}
	}
	
	public static void maxHeapInsert(int[] h, int n, int key) {
		if (n == h.length) throw new NoSuchElementException("Heap overflow");
		n = n + 1;
		h[n-1] = Integer.MIN_VALUE;
		increaseKey(h, n, n-1, key);
	}

	public static void maxHeapify(int[] h, int i, int n) {
		int l = left(i);
		int r = right(i);
		int largest;
		if (l < n && h[l] > h[i])
			largest = l;
		else largest = i;
		if (r < n && h[r] > h[largest])
			largest = r;
		if (largest != i) {
			exchange(h, i, largest);
			maxHeapify(h, largest, n);
		}
	}
	
	private static void exchange(int[] h, int i, int j) {
		int aux = h[i];
		h[i] = h[j];
		h[j] = aux;
	}
}
