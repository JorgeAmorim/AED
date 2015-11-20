package CodigoAulas.lazyIterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LazyIterators {
	
	/*
	Retorna um objecto com a interface Iterable<E>, representando a sequência src sem os elementos duplicados.
	A sequência representada por src está ordenada. Exemplificando: caso src represente a sequência de
	inteiros [2; 4; 4; 4; 5; 9; 9; 10; 10; 11], o objecto retornado deve representar a sequência [2; 4; 5; 9; 10; 11].
	A implementação deste método deve minimizar o espaço ocupado pelo iterador.
	Não é necessário implementar o método remove, pertencente à interface genérica Iterator<E>.
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
	Realize o método que dada a sequência representada por src, retorna um iterável em que os elementos pares, 
	que ocorrem em src, precedem os elementos ímpares. Note que src pode ser iterada mais do que uma vez.
	A implementação deste método deve minimizar o espaço ocupado pelo iterável. O iterador associado ao 
	iterável retornado n˜ao suporta o método remove.
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
						if ( !hasNext() ) throw new NoSuchElementException("Não existem elementos");
						Integer res = curr;
						curr = null;
						return res;
					}

					public void remove() {
						throw new UnsupportedOperationException("A remoção não é permitida");
					}	
				};
			}
		};
	}
	
	/*
	Realize o método que retorna um iterável com os elementos da sequência ordenada src que pertençam ao 
	intervalo fechado [l,r]
	A implementação deste método deve minimizar o espaço ocupado pelo iterável. O iterador associado ao 
	iterável retornado n˜ao suporta o método remove.
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
	Realize o método estático que retorna um iterável com os elementos menores ou iguais a value, existentes na 
	sequência ordenada de modo crescente src. A sequência a retornar n˜ao deverá conter elementos repetidos. 
	A implementação deste método deve minimizar o espaço ocupado pelo iterável. O iterador associado ao 
	iterável retornado n˜ao suporta o método remove.
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
	Realize o método estático que retorna um iterável com os elementos da sequência src que ocorram antes do primeiro
	elemento que não verifique o predicado pred.
	Por exemplo, no caso da sequência src ser definida por {2, 4, 6, 1, 3, 2}, e se o método evaluate retornar false
	quando o número dor ímpar, o objeto retornado deve representar a sequência {2, 4, 6}.
	A implementação deste método deve minimizar o espaço ocupado pelo iterável. O iterador associado ao 
	iterável retornado n˜ao suporta o método remove.
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
	Realize o método estático que retorna um iterável com todos os elementos que satisfazem o predicado pred, 
	presentes na sequência equivalente à concatenaç˜ao das sequências presentes em src.
	A implementação deste método deve minimizar o espaço ocupado pelo iterável. O iterador associado ao 
	iterável retornado n˜ao suporta o método remove.
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
		
