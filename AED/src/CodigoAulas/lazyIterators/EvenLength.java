package CodigoAulas.lazyIterators;

public class EvenLength implements Predicate<String> {
	public boolean evaluate(String obj) {
		if(obj == null) return false;
		return obj.length() % 2 == 0;
	}
} 