package CodigoAulas.maxSubArray;

public class Kadane {
	
	public static int maximumSubArray (int[] a, int first, int last){
	    int maxSumEndingHere = 0;// soma encontrada num subarray
	    int maxSumSoFar = 0;	  // soma máxima já encontrada
	    for (int i = first; i <= last; i++) {
	        maxSumEndingHere = Math.max(maxSumEndingHere + a[i], 0);
	        maxSumSoFar = Math.max(maxSumEndingHere, maxSumSoFar);
	    }
	    return maxSumSoFar;
	}
}
