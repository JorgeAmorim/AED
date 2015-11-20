package CodigoAulas.lazyIterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LazyIterators {
	
	/*
	Retorna um objecto com a interface Iterable<E>, representando a sequ�ncia src sem os elementos duplicados.
	A sequ�ncia representada por src est� ordenada. Exemplificando: caso src represente a sequ�ncia de
	inteiros [2; 4; 4; 4; 5; 9; 9; 10; 10; 11], o objecto retornado deve representar a sequ�ncia [2; 4; 5; 9; 10; 11].
	A implementa��o deste m�todo deve minimizar o espa�o ocupado pelo iterador.
	N�o � necess�rio implementar o m�todo remove, pertencente � interface gen�rica Iterator<E>.
	*/
	public static Iterable<Integer> distinct(final Iterable<Integer> src) {
		return new Iterable<Integer>() {
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					Iterator<Integer> it = src.iterator();
					Integer curr, prev;
					
					public boolean hasNext() {
						while (curr == null) {
							if (it.hasNext()) { 
								curr = it.next();
								if (curr.equals(prev)) curr = null; 
							}
							else return false;
						}
						return true;
					}

					public Integer next() {
						if (!hasNext()) throw new NoSuchElementException("no more elements");
						prev = curr;
						curr = null;
						return prev;
					}

					public void remove() {
						throw new UnsupportedOperationException("not allowed");
					}
					
				};
			}
		};
	}
	
	/*
	Realize o m�todo que dada a sequ�ncia representada por src, retorna um iter�vel em que os elementos pares, 
	que ocorrem em src, precedem os elementos �mpares. Note que src pode ser iterada mais do que uma vez.
	A implementa��o deste m�todo deve minimizar o espa�o ocupado pelo iter�vel. O iterador associado ao 
	iter�vel retornado n�ao suporta o m�todo remove.
	*/
	public static Iterable<Integer> evenOdd(final Iterable<Integer> src) {
		return new Iterable<Integer>() {
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					Iterator<Integer> it = src.iterator();
					boolean even=true;
					Integer curr;
					public boolean hasNext() {
						while (curr == null) {
							if (it.hasNext()) {
								curr = it.next();
								if ((curr % 2 == 0) != even) curr= null;
							}
							else {
								if (even) { it = src.iterator(); even = false; }
								else return false;
							}
						}
						return true;
					}

					public Integer next() {
						if ( !hasNext() ) throw new NoSuchElementException("N�o existem elementos");
						Integer res = curr;
						curr = null;
						return res;
					}

					public void remove() {
						throw new UnsupportedOperationException("A remo��o n�o � permitida");
					}	
				};
			}
		};
	}
	
	/*
	Realize o m�todo que retorna um iter�vel com os elementos da sequ�ncia ordenada src que perten�am ao 
	intervalo fechado [l,r]
	A implementa��o deste m�todo deve minimizar o espa�o ocupado pelo iter�vel. O iterador associado ao 
	iter�vel retornado n�ao suporta o m�todo remove.
	*/
	public static Iterable<Integer> getValuesBetween(final Iterable<Integer> src, final int l, final int r) {
		return new Iterable<Integer>() {
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					Iterator<Integer> it = src.iterator();
					Integer curr;
					
					public boolean hasNext() {
						while (curr == null) {
							if (it.hasNext()) { 
								curr = it.next();
								if (curr < l || curr > r) curr = null;
								//if (curr.compareTo(l) < 0 || curr.compareTo(r) > 0) curr = null; 
							}
							else return false;
						}
						return true;
					}

					public Integer next() {
						if (!hasNext()) throw new NoSuchElementException("no more elements");
						Integer res = curr;
						curr = null;
						return res;
					}

					public void remove() {
						throw new UnsupportedOperationException("not allowed");
					}
					
				};
			}
		};
	}
	


	/*
	Realize o m�todo est�tico que retorna um iter�vel com os elementos menores ou iguais a value, existentes na 
	sequ�ncia ordenada de modo crescente src. A sequ�ncia a retornar n�ao dever� conter elementos repetidos. 
	A implementa��o deste m�todo deve minimizar o espa�o ocupado pelo iter�vel. O iterador associado ao 
	iter�vel retornado n�ao suporta o m�todo remove.
	*/
	public static Iterable<Integer> getValuesLessThan(final Iterable<Integer> src, final int value) {
		return new Iterable<Integer>() {
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					Iterator<Integer> it = src.iterator();
					Integer curr, prev;
					
					public boolean hasNext() {
						while (curr == null) {
							if (it.hasNext()) { 
								curr = it.next();
								if (curr > value) return false;
								if (curr == prev) curr = null; 
							}
							else return false;
						}
						return true;
					}

					public Integer next() {
						if (!hasNext()) throw new NoSuchElementException("no more elements");
						prev = curr;
						curr = null;
						return prev;
					}

					public void remove() {
						throw new UnsupportedOperationException("not allowed");
					}
					
				};
			}
		};
	}
	
	/*
	Realize o m�todo est�tico que retorna um iter�vel com os elementos da sequ�ncia src que ocorram antes do primeiro
	elemento que n�o verifique o predicado pred.
	Por exemplo, no caso da sequ�ncia src ser definida por {2, 4, 6, 1, 3, 2}, e se o m�todo evaluate retornar false
	quando o n�mero dor �mpar, o objeto retornado deve representar a sequ�ncia {2, 4, 6}.
	A implementa��o deste m�todo deve minimizar o espa�o ocupado pelo iter�vel. O iterador associado ao 
	iter�vel retornado n�ao suporta o m�todo remove.
	*/
	public static Iterable<Integer> takeWhile(final Iterable<Integer> src,final Predicate<Integer> pred ) {
		return new Iterable<Integer>() {
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					Iterator<Integer> it = src.iterator();
					Integer curr, prev;
					boolean stop = false;
					
					public boolean hasNext() {
						while (curr == null) {
							if (stop) return false;
							if (it.hasNext()) { 
								curr = it.next();
								if (!pred.evaluate(curr)) {
									curr = null;
									stop = true;
								}
							}
							else return false;
						}
						return true;
					}

					public Integer next() {
						if (!hasNext()) throw new NoSuchElementException("no more elements");
						prev = curr;
						curr = null;
						return prev;
					}

					public void remove() {
						throw new UnsupportedOperationException("not allowed");
					}
					
				};
			}
		};
	}
	
	/*
	Realize o m�todo est�tico que retorna um iter�vel com todos os elementos que satisfazem o predicado pred, 
	presentes na sequ�ncia equivalente � concatena�ao das sequ�ncias presentes em src.
	A implementa��o deste m�todo deve minimizar o espa�o ocupado pelo iter�vel. O iterador associado ao 
	iter�vel retornado n�ao suporta o m�todo remove.
	*/
	public static Iterable<String> getValues(final Iterable<Iterable<String>> src,final Predicate<String> pred ) {
		return new Iterable<String>() {
			public Iterator<String> iterator() {
				return new Iterator<String>(){
					Iterator<Iterable<String>> it = src.iterator();
					String curr = null;
					
					public boolean hasNext() {
						while ( curr == null ) {
							if (it.hasNext()) {
								curr = "";
								Iterator<String> itr = it.next().iterator();
								while (itr.hasNext()) curr += itr.next();
								if (!pred.evaluate(curr)) curr = null;
							}
							else return false;
						}
						return true;
					}
					
					public String next() {
						if(!it.hasNext()) throw new NoSuchElementException();
						String res = curr;
						curr = null;
						return res;
					}
					
					public void remove() {
						throw new UnsupportedOperationException();
					}
					
				};
			}	
		};
	}
	
}
		
