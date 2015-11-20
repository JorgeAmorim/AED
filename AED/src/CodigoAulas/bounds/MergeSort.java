package CodigoAulas.bounds;

public class MergeSort {

	public static void mergeSort(int[] table){
		if(table.length >= 2) {
			int mid = table.length / 2; 
			int[] left = new int[mid];
			int[] right = new int[table.length - mid];
			/*divide os elementos de table por left e right */
			divide(table, left, right);
			mergeSort(left); 	/*ordena left*/
			mergeSort(right);	/*ordena right*/
			merge(table, left, right);
			/*junta ambas as metades em table, ordenando-as*/
		}
	}
		
	public static void divide(int[] table, int[] left, int[] right) {
		int i;
		for(i=0; i < left.length; i++) left[i] = table[i];
		for(i=0; i < right.length; i++) right[i] = table[left.length+i];
	}
	
	public static void merge(int[] table, int[] left, int[] right){
		int idxL = 0, idxR = 0, idx = 0;
		while (idxL < left.length && idxR < right.length)
			if (left[idxL] < right[idxR]) {
				table[idx] = left[idxL]; idx++; idxL++;
			}
			else {
				table[idx] = right[idxR]; idx++; idxR++;
			}
		while (idxL < left.length) { 	/*Se existir, copiar o resto de left*/
			table[idx] = left[idxL]; idxL++; idx++;
		}
		while(idxR < right.length) {	/*Se existir, copiar o resto de right*/
			table[idx] = right[idxR]; idxR++; idx++;
		}
	}
}
