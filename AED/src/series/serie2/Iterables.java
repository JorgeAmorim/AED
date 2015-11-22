package series.serie2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterables {
    public static Iterable<String> getPhrasesStart(Iterable<Iterable<String>> phrases, String prefix){
       	return new Iterable<String>() {
			@Override
			public Iterator<String> iterator() {
				return new Iterator<String>() {

                    Iterator<Iterable<String>> it = phrases.iterator();
                    String curr = null;

					@Override
                    public boolean hasNext() {
                        while (curr == null){
                            if(it.hasNext()) {
                                Iterator<String> itStr = it.next().iterator();
                                if (itStr.hasNext()) {
                                    String aux = itStr.next();
                                    if (aux == prefix) {
                                        curr = aux;
                                        while (itStr.hasNext())
                                            curr += " " + itStr.next();
                                    }
                                }
                            }
                            else return false;
                        }
                        return true;
                    }

					@Override
					public String next() {
                        if(!hasNext()) throw new NoSuchElementException();
                        String aux = curr;
                        curr = null;
                        return aux;
					}
				};
			}
		};
    }

	public static <K,V> Iterable<Pair<K,V>> getEntries(HashNode<K,V>[] hashMap){
		throw new UnsupportedOperationException();
	}

	public static <E> Iterable<Pair<E, Integer>> histogram(E[] array){
        throw new UnsupportedOperationException();
	}



}
