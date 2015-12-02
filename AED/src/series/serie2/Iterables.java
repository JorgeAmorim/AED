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

	public static <K,V> Iterable<Pair<K,V>> getEntries(final HashNode<K,V>[] hashMap){
        if(hashMap == null) return null;

		return new Iterable<Pair<K, V>>() {
            @Override
            public Iterator<Pair<K, V>> iterator() {
                return new Iterator<Pair<K, V>>() {

                    int size = hashMap.length, aux = -1;
                    HashNode<K,V> ret = new HashNode<K,V>();
                    Pair<K,V> curr = new Pair<K,V>();

                    @Override
                    public boolean hasNext() {
                        if (ret.next != null) {
                            ret = ret.next;
                            curr = ret.pair;
                        }
                        else {
                                aux += 1;
                            if (aux == size)
                                return false;
                            while (hashMap[aux] == null) {
                                aux += 1;
                                if (aux == size)
                                    return false;
                            }
                            ret = hashMap[aux];
                            curr = ret.pair;
                        }
                        return true;
                    }

                    @Override
                    public Pair<K, V> next() {
                        Pair<K,V> aux = curr;
                        curr = null;
                        return aux;
                    }
                };
            }
        };
	}

	public static <E> Iterable<Pair<E, Integer>> histogram(E[] array){

        throw new UnsupportedOperationException();
	}
}
