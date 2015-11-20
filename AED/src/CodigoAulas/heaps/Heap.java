package CodigoAulas.heaps;

public class Heap {
	
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
	
	public static void buildMaxHeap(int[] h, int n) {
		for (int i = n / 2 - 1; i >= 0; i--)
			maxHeapify(h, i, n);
	}
	
	public static void heapSort(int[] h, int n) {
		buildMaxHeap(h, n);
		for (int i = n - 1; i >= 1; i--) {
			exchange(h, i, 0);
			maxHeapify(h, 0, i);
		}
	} 
	
	public static void buildMinHeap(int[] h, int n) {
		for (int i = n / 2 - 1; i >= 0; i--)
			minHeapify(h, i, n);
	}
	
	public static void minHeapify(int[] h, int i, int n) {
		int l = left(i);
		int r = right(i);
		int smallest;
		if (l < n && h[l] < h[i])
			smallest = l;
		else smallest = i;
		if (r < n && h[r] < h[smallest])
			smallest = r;
		if (smallest != i) {
			exchange(h, i, smallest);
			minHeapify(h, smallest, n);
		}
	}
}
