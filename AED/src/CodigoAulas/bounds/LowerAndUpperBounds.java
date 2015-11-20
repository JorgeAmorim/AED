package CodigoAulas.bounds;

public class LowerAndUpperBounds {
	/*
	Realize o método estático que, dado um subarray (table, first, last) de inteiros, ordenado de forma crescente, 
	sem possibilidade de ocorrerem repetições, calcula o comprimento da subsequência desse subarray cujos 
	valores est˜ao compreendidos entre min e max, inclusive. Estes podem ou não existir no array.
	 */
	public static int distanceBetweenLinear(int[] table, int first, int last, int min, int max) {
		int distance = 0;
		while (first <= last) {
			if (table[first] >= min && table[first] <= max) distance++; 
			first++;
		}
		return distance;
	}
	
	public static int distanceBetweenBinary(int[] table, int first, int last, int min, int max) {
	    int lower = lowerBound(table, first, last, min);
	    int upper = upperBound(table, first, last, max);
	    return (lower >= first && upper <= last) ? upper - lower + 1 : 0; 
	}
	
	// binaySearch adaptado de forma a devolver o indice do elemento <= max
	public static int upperBound (int[] table, int first, int last, int max){	
    	int mid = (first + last) / 2;
    	//System.out.println("first = " + first + " last = " + last + " mid = " + mid);
	    if (first > last) return (max > table[mid]) ? mid : mid - 1;
	    else {
	    	if (max == table[mid]) return mid;
	    	else if (max < table[mid]) return upperBound(table, first, mid - 1, max);
	    	else return upperBound(table, mid + 1, last, max);
	    }
	}
	
	// binaySearch adaptado de forma a devolver o indice do elemento >= min
	public static int lowerBound (int[] table, int first, int last, int min){	
    	int mid = (first + last) / 2;
    	//System.out.println("first = " + first + " last = " + last + " mid = " + mid);
	    if (first > last) return (min < table[mid]) ? mid : mid + 1;
	    else {
	    	if (min == table[mid]) return mid;
	    	else if (min < table[mid]) return lowerBound(table, first, mid - 1, min);
	    	else return lowerBound(table, mid + 1, last, min);
	    }
	}
}
