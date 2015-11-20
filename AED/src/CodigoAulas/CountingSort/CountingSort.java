package CodigoAulas.CountingSort;

public class CountingSort {
	
	public static int[] countingSort(int[] a, int l, int u){
		int n = a.length;
		int[] s = new int[n];
		int[] f = new int[u - l + 1];
		for (int i = 0; i < n; i++)	 		
			f[a[i] - 1]++;					// compute frequencies
		for (int j = 1; j <= u - l; j++)
			f[j] = f[j - 1] + f[j];			// reuse for distribution
		for (int i = n - 1; i >= 0; i--) {	// copy to sorted array
			int j = a[i] - l;
			s[f[j] - 1] = a[i];
			f[j]--;
		}
		return s;
	}

}
