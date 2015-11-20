package CodigoAulas.lazyIterators;

public class Even implements Predicate<Integer> {
	// An object of type Even tests an Object of type Integer to see whether the integer
    // that it represents is an even number. 
    // Note that the test() method should only be applied to non-null values of type Integer.
	public boolean evaluate(Integer obj) {
		if(obj == null) return false;
		return obj % 2 == 0;
	}
} // end class Even