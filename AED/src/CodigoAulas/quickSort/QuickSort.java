package CodigoAulas.quickSort;

public class QuickSort {

	public static void quickSort(int[] a, int left, int right) {
	      int i;
	      if (right <= left) return;
	      i = partition(a, left, right);
	      quickSort(a, left, i - 1);
	      quickSort(a, i + 1, right);
	}
	
    public static int partition(int[] a, int p, int r) {
        int x = a[r];  // elemento de partição
	    int i = p - 1;
	    for (int j = p; j < r; j++) {
	    	if (a[j] <= x) {
	    		i++;
	    		exchange(a, i, j);
	    	}
	    }
	    exchange(a, i+1, r);  
	    return i + 1;
	}

	public static void exchange(int[] a, int i, int j) {
		int aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}
}
