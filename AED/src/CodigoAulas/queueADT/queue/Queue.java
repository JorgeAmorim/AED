package CodigoAulas.queueADT.queue;

public interface Queue<E> {
	public boolean isEmpty();
	public E enqueue(E item);
	public E dequeue();
	public E peek();
}
