package CodigoAulas.CountingSort;

import static CodigoAulas.CountingSort.CountingSort.countingSort;

public class TestSort {

	public static void main(String[] args) {
		int[] table = {4, 1, 3, 2, 16, 3, 10, 14, 8, 7};
		int[] sTable = new int[table.length];
		
		show(table);
		sTable = countingSort(table, 1, 16);
		show(sTable);
	}

	public static void show(int[] t) {
		for (int i = 0; i < t.length; i++)
			System.out.print(t[i] + " ");
		System.out.println();
	}

}
