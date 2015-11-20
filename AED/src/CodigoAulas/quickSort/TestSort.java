package CodigoAulas.quickSort;

public class TestSort {

	public static void main(String[] args) {
		int[] table = {4, 1, 3, 2, 16, 3, 10, 14, 8, 7};
		
		show(table);
		QuickSort.quickSort(table, 0, table.length-1);
		show(table);
	}

	public static void show(int[] t) {
		for (int i = 0; i < t.length; i++)
			System.out.print(t[i] + " ");
		System.out.println();
	}

}
