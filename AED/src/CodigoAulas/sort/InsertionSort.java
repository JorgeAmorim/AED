package CodigoAulas.sort;

public class InsertionSort {
	
	public static void insertionSort(int[] table, int first, int last) {
	      
	    for (int i = first + 1; i <= last; i++)
	    	for (int j = i; j > first; j--)
	    		if (table[j] < table[j-1]) {
	    			int aux = table[j];
	    			table[j] = table[j-1];
	    			table[j-1] = aux;
	    		}
	}
	
	public static void insertionSortImproved(int[] table, int first, int last) {
		for (int i = last; i > first; i--)  // procura o menor valor 
			if (table[i] < table[i-1]) {	// e arruma-o na 1ª posição (sentinela)
				int aux = table[i]; table[i] = table[i-1]; table[i-1] = aux; 
			}
		for (int i = first + 2; i <= last; i++) {
			int j = i; int aux = table[i];
			while (aux < table[j-1]) {
				table[j] = table[j-1]; j--;
			}
			table[j] = aux;
		}
	}

}
