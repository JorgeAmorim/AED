package CodigoAulas.stackADT.stack;

public interface Stack<E> {
	public boolean isEmpty();
	public E push(E item);
	public E pop();
	public E peek();
}
