package CodigoAulas.lazyIterators;
/*
 * A predicate is a boolean-valued function with one parameter. 
 * Some languages use predicates in generic programming. 
 * Java doesn't.
 */

/*
* In Java, we could use "predicate objects" by defining an interface:
* The idea is that an object that implements this interface knows how 
* to evaluate objects in some way.
*/

public interface Predicate<E> {
	 public boolean evaluate(E obj);
}
 