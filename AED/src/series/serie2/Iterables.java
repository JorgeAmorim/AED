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
                                    //guarda a primeira palavra do iterador phrases
                                    String aux = itStr.next();
                                    //verifica se essa primeira palavra é igual ao prefixo
                                    if (aux == prefix) {
                                        curr = aux;
                                        //caso seja igual copia o resto da fraze para o curr a ser retornado no next()
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
                        //verifica se o hashnode tem next e guarda esse novo hashnode e introduz o novo par na
                        //variavel curr que depois é retornada no proximo next()
                        if (ret.next != null) {
                            ret = ret.next;
                            curr = ret.pair;
                        }
                        //caso nao tenha next procura um novo hashnode que seja diferente de null
                        //e guarda esse novo hashnode e o seu pair para o retorno
                        else {
                                aux += 1;
                            if (aux == size)
                                return false;
                            //ciclo que procura o proximo hashnode diferente de null
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
        return new Iterable<Pair<E, Integer>>() {
            @Override
            public Iterator<Pair<E, Integer>> iterator() {
                return new Iterator<Pair<E, Integer>>() {
                    int count = 1, aux = 0;
                    Pair<E, Integer> curr = new Pair<E, Integer>();
                    @Override
                    public boolean hasNext() {
                        //verifica se o array ainda tem valores ou se ja chegou ao fim
                        if(aux != array.length) {
                            E xpto = array[aux++];
                            //conta quantas vezes esse valor existe no array
                            while (aux < array.length && array[aux] == xpto ) {
                                count++;
                                aux++;
                            }
                            //guarda na variavel a ser retornada no proximo next() com o seu valor E e
                            //a contagem de vezes que ocorreu
                            curr = new Pair<E, Integer>(xpto, count);
                            count = 1;
                            return true;
                        }
                        return false;
                    }

                    @Override
                    public Pair<E, Integer> next() {
                        Pair<E,Integer> aux = curr;
                        curr = null;
                        return aux;
                    }
                };
            }
        };
    }
}
