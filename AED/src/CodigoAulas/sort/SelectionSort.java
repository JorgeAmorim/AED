package CodigoAulas.sort;

public class SelectionSort {
	
	public static void selectionSort(int[] table, int first, int last) {
		for (int i = first; i < last; i++) {
			int min = i;
			for (int j = i + 1; j <= last; j++)
				if (table[j] < table[min]) min = j;
			int aux = table[i];
			table[i] = table[min];
			table[min] = aux;
		}
	}	
}
