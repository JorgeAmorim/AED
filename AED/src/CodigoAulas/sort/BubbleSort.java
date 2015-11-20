package CodigoAulas.sort;

public class BubbleSort {
	
	public static void bubbleSort(int[] table, int first, int last) {
	      
	    for (int i = first; i < last; i++)  { 
	    	for (int j = last; j > i; j--)
	    		if (table[j] < table[j-1]) {
	    			int aux = table[j];
	    			table[j] = table[j-1];
	    			table[j-1] = aux;
	    		}
	    }
	}

	public static void bubbleSortImproved(int[] table, int first, int last) {
		boolean trocas = false;
		for (int i = first; i < last; i++) {
			for (int j = last; j > i; j--)
				if (table[j] < table[j-1]) {
					int aux = table[j]; 
					table[j] = table[j-1]; 
					table[j-1] = aux;
					trocas = true;
				}
			if (trocas) trocas = false; else break;
		}
	}	
}
